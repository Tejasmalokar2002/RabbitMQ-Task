package com.example.RabbitMQ.service;

import com.example.RabbitMQ.DTO.MessageDTO;
import com.example.RabbitMQ.model.CommonEntity;
import com.example.RabbitMQ.repository.CommonEntityRepository;
import com.example.RabbitMQ.repository.DepartmentRepository;
import com.example.RabbitMQ.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class MessageProcessorService {

    private static final Logger logger = LoggerFactory.getLogger(MessageProcessorService.class);

    @Autowired
    private CommonEntityRepository commonEntityRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void processMessages() {
        // Fetch all unread messages from commonentity
        List<CommonEntity> unreadMessages = commonEntityRepository.findByIsReadFalse();

        ObjectMapper objectMapper = new ObjectMapper();

        for (CommonEntity commonEntity : unreadMessages) {
            try {
                // Convert byte array to JSON string using UTF-8 encoding
                String jsonMessage = new String(commonEntity.getMessage(), StandardCharsets.UTF_8);

                // Log the received message for debugging purposes
                logger.info("Processing message: " + jsonMessage);

                // Convert JSON string to MessageDTO
                MessageDTO messageDTO = objectMapper.readValue(jsonMessage, MessageDTO.class);

                // Save the student and department data to respective tables
                if (messageDTO.getStudent() != null) {
                    studentRepository.save(messageDTO.getStudent());
                }

                if (messageDTO.getDepartment() != null) {
                    departmentRepository.save(messageDTO.getDepartment());
                }

                // Mark the message as read
                commonEntity.setIsRead(true);
                commonEntityRepository.save(commonEntity);

                logger.info("Message processed and saved successfully");

            } catch (Exception e) {
                // Log the exception with message details
                logger.error("Failed to process message: " + new String(commonEntity.getMessage(), StandardCharsets.UTF_8), e);
            }
        }

        // After processing messages, update isRead to false for messages processed
        updateIsReadFlag();
    }

    private void updateIsReadFlag() {
        List<CommonEntity> processedMessages = commonEntityRepository.findByIsReadFalse();
        for (CommonEntity commonEntity : processedMessages) {
            commonEntity.setIsRead(false);
            commonEntityRepository.save(commonEntity);
        }
    }
}
