package com.example.RabbitMQ.repository;

import com.example.RabbitMQ.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
