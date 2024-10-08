package com.example.RabbitMQ.repository;

import com.example.RabbitMQ.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
