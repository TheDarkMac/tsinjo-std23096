package com.example.demo.repository;

import com.example.demo.model.Donation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {
  List<Donation> findAllByOrderByPaymentDateDesc();
}
