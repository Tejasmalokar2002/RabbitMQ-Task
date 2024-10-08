
package com.example.RabbitMQ.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// CommonEntity entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private byte[] message; // To store byte array
    private Boolean isRead = false;

    // Getters and setters
}
