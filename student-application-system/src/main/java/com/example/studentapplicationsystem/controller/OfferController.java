package com.example.studentapplicationsystem.controller;

import com.example.studentapplicationsystem.model.Offer;
import com.example.studentapplicationsystem.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@CrossOrigin(origins = "*")
public class OfferController {

    @Autowired
    private OfferService offerService;

    // GET /api/offers
    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    // GET /api/offers/company/{company}
    @GetMapping("/company/{company}")
    public List<Offer> getOffersByCompany(@PathVariable String company) {
        return offerService.getOffersByCompany(company);
    }

    // GET /api/offers/student/{id}
    @GetMapping("/student/{id}")
    public List<Offer> getOffersByStudent(@PathVariable Integer id) {
        return offerService.getOffersByStudent(id);
    }

    // GET /api/offers/year/{year}
    @GetMapping("/year/{year}")
    public List<Offer> getOffersByYear(@PathVariable int year) {
        return offerService.getOffersByYear(year);
    }
}

