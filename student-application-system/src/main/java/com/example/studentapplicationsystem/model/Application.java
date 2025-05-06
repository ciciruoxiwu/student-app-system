package com.example.studentapplicationsystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "apply_date")
    private LocalDate applyDate;

    @Column(name = "reject_date")
    private LocalDate rejectDate;

    @Column(name = "offer_date")
    private LocalDate offerDate;

    // --- Getters & Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public LocalDate getApplyDate() { return applyDate; }
    public void setApplyDate(LocalDate applyDate) { this.applyDate = applyDate; }

    public LocalDate getRejectDate() { return rejectDate; }
    public void setRejectDate(LocalDate rejectDate) { this.rejectDate = rejectDate; }

    public LocalDate getOfferDate() { return offerDate; }
    public void setOfferDate(LocalDate offerDate) { this.offerDate = offerDate; }
}
