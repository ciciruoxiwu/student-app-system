package com.example.studentapplicationsystem.controller;

import com.example.studentapplicationsystem.model.Application;
import com.example.studentapplicationsystem.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*") // Allow frontend to access backend API
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // GET /api/applications
    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    // GET /api/applications/{id}
    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Integer id) {
        return applicationService.getApplicationById(id);
    }

    // POST /api/applications
    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.saveApplication(application);
    }

    // PUT /api/applications/{id}
    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable Integer id, @RequestBody Application application) {
        application.setId(id); // ensure correct ID
        return applicationService.saveApplication(application);
    }

    // DELETE /api/applications/{id}
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Integer id) {
        applicationService.deleteApplication(id);
    }
}
