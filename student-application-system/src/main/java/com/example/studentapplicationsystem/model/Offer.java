package com.example.studentapplicationsystem.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id")
    @JsonProperty("studentId")
    private Integer studentId;

    @Column(name = "company_name")
    @JsonProperty("companyName")
    private String companyName;

    @Column(name = "offer_date")
    @JsonProperty("offerDate")
    private LocalDate offerDate;

    @Column(name = "status")
    @JsonProperty("status")
    private String status; // accepted, rejected, underconsideration

    @Column(name = "salary")
    @JsonProperty("salary")
    private Integer salary;

    @Column(name = "decision_year")
    @JsonProperty("decisionYear")
    private Integer decisionYear;

    // --- Getters & Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public LocalDate getOfferDate() { return offerDate; }
    public void setOfferDate(LocalDate offerDate) { this.offerDate = offerDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getSalary() { return salary; }
    public void setSalary(Integer salary) { this.salary = salary; }

    public Integer getDecisionYear() { return decisionYear; }
    public void setDecisionYear(Integer decisionYear) { this.decisionYear = decisionYear; }
}




