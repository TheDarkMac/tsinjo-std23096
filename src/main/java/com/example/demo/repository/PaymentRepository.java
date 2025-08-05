package com.example.demo.repository;

import com.example.demo.model.Payment;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
  Optional<Payment> findByPspId(String externalId);
}
