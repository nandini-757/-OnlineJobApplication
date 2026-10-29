package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CandidateProfile;
import com.example.demo.entity.JobApplication;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CandidateProfileRepository;
import com.example.demo.repository.JobApplicationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
	private final JobApplicationRepository jobApplicationRepository;
	
	public JobApplication saveJobApplication(JobApplication jobApplication) {
		return jobApplicationRepository.save(jobApplication);
	}
	
	public List<JobApplication> getAllApplications(){
		return jobApplicationRepository.findAll();
	}
	public JobApplication getApplicationById(Long id) {
		return jobApplicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found"));
	}
	public JobApplication updateApplication(Long id,JobApplication jobApplication) {
		JobApplication existing=getApplicationById(id);
		
		existing.setName(jobApplication.getName());
		existing.setEmail(jobApplication.getEmail());
		existing.setMobileNumber(jobApplication.getMobileNumber());
		existing.setDateOfBirth(jobApplication.getDateOfBirth());
		existing.setPassedOutYear(jobApplication.getPassedOutYear());
		existing.setCollegeName(jobApplication.getCollegeName());
		existing.setResume(jobApplication.getResume());
		
		return jobApplicationRepository.save(existing);
	
	}
	

}
