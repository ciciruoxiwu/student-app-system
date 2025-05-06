package com.example.studentapplicationsystem.controller;

import com.example.studentapplicationsystem.model.Company;
import com.example.studentapplicationsystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // GET /api/companies
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // GET /api/companies/{name}
    @GetMapping("/{name}")
    public Company getCompanyByName(@PathVariable String name) {
        return companyService.getCompanyByName(name);
    }

    // POST /api/companies
    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    // PUT /api/companies/{name}
    @PutMapping("/{name}")
    public Company updateCompany(@PathVariable String name, @RequestBody Company company) {
        company.setName(name);
        return companyService.saveCompany(company);
    }

    // DELETE /api/companies/{name}
    @DeleteMapping("/{name}")
    public void deleteCompany(@PathVariable String name) {
        companyService.deleteCompany(name);
    }
}

