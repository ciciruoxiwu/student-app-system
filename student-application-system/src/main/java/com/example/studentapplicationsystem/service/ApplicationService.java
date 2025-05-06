package com.example.studentapplicationsystem.service;

import com.example.studentapplicationsystem.model.Application;
import com.example.studentapplicationsystem.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // get all request
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // get request based on ID
    public Application getApplicationById(Integer id) {
        return applicationRepository.findById(id).orElse(null);
    }

    // build or update request
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    // delete request
    public void deleteApplication(Integer id) {
        applicationRepository.deleteById(id);
    }
}

