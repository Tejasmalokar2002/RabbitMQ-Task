package com.example.RabbitMQ.DTO;

import com.example.RabbitMQ.model.Department;
import com.example.RabbitMQ.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO for the message
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private Student student;
    private Department department;

    // Getters and setters
}