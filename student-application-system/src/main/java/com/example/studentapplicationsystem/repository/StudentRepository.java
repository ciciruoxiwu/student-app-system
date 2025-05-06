package com.example.studentapplicationsystem.repository;

import com.example.studentapplicationsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // You can define custom query methods here if needed
}

