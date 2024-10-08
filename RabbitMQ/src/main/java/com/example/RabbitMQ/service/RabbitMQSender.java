package com.example.RabbitMQ.service;

import com.example.RabbitMQ.DTO.MessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// RabbitMQ Sender (Publisher)
@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String exchange = "exchange_name";
    private String routingKey = "routing_key";

    public void sendMessage(MessageDTO messageDTO) throws JsonProcessingException {
        // Convert messageDTO to JSON and then to byte array
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMessage = objectMapper.writeValueAsString(messageDTO);
        byte[] byteMessage = jsonMessage.getBytes();

        // Send message to queue
        rabbitTemplate.convertAndSend(exchange, routingKey, byteMessage);
    }
}

