package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Beneficiary {
  private String email;
  private String fullName;
}
