package com.example.RabbitMQ.service;

import com.example.RabbitMQ.model.CommonEntity;
import com.example.RabbitMQ.repository.CommonEntityRepository;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiver {

    @Autowired
    private CommonEntityRepository commonEntityRepository;

    @RabbitListener(queues = "queue_name")
    @RabbitListener(queues = "queue_name")
    public void receiveMessage(byte[] byteMessage) {
        try {
            System.out.println("Received message of size: " + byteMessage.length);
            // Save the byte stream into the commonentity table
            CommonEntity commonEntity = new CommonEntity();
            commonEntity.setMessage(byteMessage);
            commonEntity.setIsRead(false); // Mark as unread initially
            commonEntityRepository.save(commonEntity);
            System.out.println("Message saved successfully.");
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }


    @Bean
    public Queue myQueue() {
        return new Queue("queue_name", true);  // true for durable queue
    }
}
