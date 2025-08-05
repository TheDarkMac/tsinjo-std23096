package com.example.demo.service;

import com.example.demo.endpoint.dto.DonationView;
import com.example.demo.model.Donation;
import com.example.demo.model.Donor;
import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import com.example.demo.repository.DonationRepository;
import com.example.demo.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final PaymentRepository paymentRepository;

    public DonationService(DonationRepository donationRepository, PaymentRepository paymentRepository) {
        this.donationRepository = donationRepository;
        this.paymentRepository = paymentRepository;
    }

    @Transactional
    public void receiveDonation(String email, String paymentMethod, String externalId) {
        Payment payment = new Payment();
        payment.setDate(LocalDateTime.now());
        payment.setAmountInMiaraka(0); // À mettre à jour via Vola async
        payment.setPaymentType(paymentMethod);
        payment.setPspId(externalId);
        payment.setPaymentStatus(PaymentStatus.VERIFYING);
        paymentRepository.save(payment);

        Donor donor = new Donor(email);
        Donation donation = new Donation();
        donation.setDonor(donor);
        donation.setPayment(payment);

        donationRepository.save(donation);
    }

    public List<DonationView> listDonationsForView() {
        List<Donation> donations = donationRepository.findAll();

        return donations.stream()
                .map(this::toView)
                .collect(Collectors.toList());
    }

    private DonationView toView(Donation donation) {
        return new DonationView(
                donation.getId(),
                donation.getPayment().getAmountInMiaraka(),
                donation.getDonor().getFullName(),
                donation.getPayment().getDate().toLocalDate()
        );
    }
}
