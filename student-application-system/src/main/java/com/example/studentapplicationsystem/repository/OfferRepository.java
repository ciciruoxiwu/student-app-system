package com.example.studentapplicationsystem.repository;

import com.example.studentapplicationsystem.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
    // Optional: methods for filtering report

    List<Offer> findByCompanyName(String companyName);
    List<Offer> findByStudentId(Integer studentId);
    List<Offer> findByOfferDateBetween(java.time.LocalDate start, java.time.LocalDate end);
}
