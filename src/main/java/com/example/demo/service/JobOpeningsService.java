package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.JobApplication;
import com.example.demo.entity.JobOpenings;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.JobApplicationRepository;
import com.example.demo.repository.JobOpeningsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobOpeningsService {
	private final JobOpeningsRepository jobOpeningsRepository;
	
	public JobOpenings saveJobOpening(JobOpenings jobOpenings) {
		return jobOpeningsRepository.save(jobOpenings);
	}
	
	public List<JobOpenings> getAllOpenings(){
		return jobOpeningsRepository.findAll();
	}
	public JobOpenings getOpeningsById(Long jobId) {
		return jobOpeningsRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"));
	}
	public JobOpenings updateOpening(Long jobId,JobOpenings jobOpenings) {
		JobOpenings existing=getOpeningsById(jobId);
		
		existing.setJobId(jobOpenings.getJobId());
		existing.setRole(jobOpenings.getRole());
		existing.setJobDescription(jobOpenings.getJobDescription());
		existing.setSalary(jobOpenings.getSalary());
		
		return jobOpeningsRepository.save(existing);
		
	}
	public void deleteOpening(Long jobId) {
		jobOpeningsRepository.deleteById(jobId);
	}

}
