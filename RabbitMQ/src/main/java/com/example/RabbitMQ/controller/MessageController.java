package com.example.RabbitMQ.controller;

import com.example.RabbitMQ.service.MessageProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageProcessorService messageProcessorService;

    @PostMapping("/process")
    public ResponseEntity<String> processMessages() {
        messageProcessorService.processMessages();
        return ResponseEntity.ok("Messages processed successfully.");
    }
}

