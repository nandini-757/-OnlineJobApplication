package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.JobApplication;
import com.example.demo.entity.JobOpenings;
import com.example.demo.service.JobApplicationService;
import com.example.demo.service.JobOpeningsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobOpenings")
@RequiredArgsConstructor
public class JobOpeningsController {
	private final JobOpeningsService jobOpeningsService;
	
	@PostMapping
	public JobOpenings saveJobOpening(@RequestBody JobOpenings jobOpenings) {
		return jobOpeningsService.saveJobOpening(jobOpenings);
	}
	
	@GetMapping
	public List<JobOpenings> getAllOpenings(){
		return jobOpeningsService.getAllOpenings();
	}
	
	@GetMapping("/{jobId}")
	public JobOpenings getOpeningById(@PathVariable Long jobId) {
		return jobOpeningsService.getOpeningsById(jobId);
	}
	@PutMapping("/{jobId}")
	public JobOpenings updateOpening(@PathVariable Long jobId, @RequestBody JobOpenings jobOpenings) {
		return jobOpeningsService.updateOpening(jobId,jobOpenings);
	}
	@DeleteMapping("/{jobId}")
	public String deleteOpening(@PathVariable Long jobId) {
		jobOpeningsService.deleteOpening(jobId);
		return "Job Opening was deleted";
		
	}

}
