package com.example.studentapplicationsystem.service;

import com.example.studentapplicationsystem.model.Company;
import com.example.studentapplicationsystem.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyByName(String name) {
        return companyRepository.findById(name).orElse(null);
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(String name) {
        companyRepository.deleteById(name);
    }
}
