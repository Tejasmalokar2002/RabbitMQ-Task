package com.example.RabbitMQ.schedular;

import com.example.RabbitMQ.service.MessageProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {

    @Autowired
    private MessageProcessorService messageProcessorService;

    @Scheduled(fixedRate = 5000) // Runs every 5 seconds
    public void processMessagesPeriodically() {
        messageProcessorService.processMessages();
    }
}
