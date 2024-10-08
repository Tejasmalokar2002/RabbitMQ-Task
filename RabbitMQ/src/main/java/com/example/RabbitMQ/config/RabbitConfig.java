package com.example.RabbitMQ.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit // Enable RabbitMQ
public class RabbitConfig {

    // Declare your queue
    @Bean
    public Queue queue() {
        return new Queue("queue_name", true); // Set durable to true if you want the queue to survive broker restarts
    }

    // Additional RabbitMQ beans can go here, e.g., RabbitTemplate, ConnectionFactory, etc.
}
