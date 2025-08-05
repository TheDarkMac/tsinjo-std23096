package com.example.demo.model;

import java.time.LocalDateTime;

public class Payment {
    private Long id;
    private LocalDateTime date;
    private int amountInMiaraka;
    private String paymentType;
    private String pspId;
    private PaymentStatus paymentStatus;
}
