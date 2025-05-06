package com.example.studentapplicationsystem.service;

import com.example.studentapplicationsystem.model.Offer;
import com.example.studentapplicationsystem.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public List<Offer> getOffersByCompany(String companyName) {
        return offerRepository.findByCompanyName(companyName);
    }

    public List<Offer> getOffersByStudent(Integer studentId) {
        return offerRepository.findByStudentId(studentId);
    }

    public List<Offer> getOffersByYear(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return offerRepository.findByOfferDateBetween(start, end);
    }
}

