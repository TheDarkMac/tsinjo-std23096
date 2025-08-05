package com.example.demo.endpoint.dto;

import java.time.LocalDate;

public record DonationView (
    Long id,
    int amount,
    String donorName,
    LocalDate date
){}