package com.example.demo.endpoint.rest.controller;

import org.springframework.stereotype.Controller;

@Controller
public class DashboardController {
    private final DonationService donationService;

    public DashboardController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/")
    public String showPage(Model model) {
        List<DonationView> views = donationService.listDonationsForView();
        model.addAttribute("donations", views);
        return "tsinjo";
    }

    @PostMapping("/donate")
    public String donate(@RequestParam String email,
                         @RequestParam String paymentMethod,
                         @RequestParam String paymentRef) {

        donationService.receiveDonation(email, paymentMethod, paymentRef);
        return "redirect:/";
    }
}
