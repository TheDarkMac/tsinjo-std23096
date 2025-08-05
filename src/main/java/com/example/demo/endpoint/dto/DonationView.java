package com.example.demo.endpoint.dto;

import java.time.LocalDateTime;

public class DonationView {
    public String donorName;
    public String donorEmail;
    public String paymentMethod;
    public String paymentRef;
    public String status;
    public Integer amount;
    public LocalDateTime date;

    public String beneficiaryName; // null si pas d’aide
    public String beneficiaryEmail;
    public String comment;
}
