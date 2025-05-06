package com.example.studentapplicationsystem.repository;

import com.example.studentapplicationsystem.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    // Primary key is String (company name)
}

