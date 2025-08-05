package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public record Help(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id,
    @Embedded
    Beneficiary beneficiary,
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    Payment payment,
    String description
    ){}
