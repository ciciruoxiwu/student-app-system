package com.example.studentapplicationsystem.repository;

import com.example.studentapplicationsystem.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    // inherit all CURD（findAll, save, deleteById, etc）
}
