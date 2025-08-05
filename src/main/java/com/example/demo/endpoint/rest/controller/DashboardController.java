package com.example.demo.endpoint.rest.controller;

import com.example.demo.endpoint.dto.DonationView;
import com.example.demo.service.DonationService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class DashboardController {

  private final DonationService donationService;

  @GetMapping("/")
  public String showPage(Model model) {
    List<DonationView> views = donationService.listDonationsForView();
    model.addAttribute("donations", views);
    return "tsinjo";
  }

  @PostMapping("/donate")
  public String donate(
      @RequestParam String email,
      @RequestParam String paymentMethod,
      @RequestParam String paymentRef) {

    donationService.receiveDonation(email, paymentMethod, paymentRef);
    return "redirect:/";
  }
}
