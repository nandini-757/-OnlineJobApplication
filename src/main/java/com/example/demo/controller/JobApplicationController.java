package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CandidateProfile;
import com.example.demo.entity.JobApplication;
import com.example.demo.service.CandidateProfileService;
import com.example.demo.service.JobApplicationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobApplication")
@RequiredArgsConstructor
public class JobApplicationController {
	
private final JobApplicationService jobApplicationService;
	
	@PostMapping
	public JobApplication saveJobApplication(@RequestBody JobApplication jobApplication) {
		return jobApplicationService.saveJobApplication(jobApplication);
	}
	
	@GetMapping
	public List<JobApplication> getAllApplications(){
		return jobApplicationService.getAllApplications();
	}
	
	@GetMapping("/{id}")
	public JobApplication getApplicationById(@PathVariable Long id) {
		return jobApplicationService.getApplicationById(id);
	}
	@PutMapping("/{id}")
	public JobApplication updateApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
		return jobApplicationService.updateApplication(id,jobApplication);
	}
	

}
