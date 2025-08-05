package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime date;
    int amountInMiaraka;
    String paymentType;
    @Column(unique = true)
    String pspId;
    PaymentStatus paymentStatus;
}
