package com.example.RabbitMQ.repository;

import com.example.RabbitMQ.model.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommonEntityRepository extends JpaRepository<CommonEntity, Long> {
    List<CommonEntity> findByIsReadFalse();
}
