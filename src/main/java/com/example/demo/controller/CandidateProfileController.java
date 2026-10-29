package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CandidateProfile;
import com.example.demo.service.CandidateProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/candidateProfile")
@RequiredArgsConstructor
public class CandidateProfileController {
	private final CandidateProfileService candidateProfileService;
	
	@PostMapping
	public CandidateProfile saveprofile(@RequestBody CandidateProfile candidateProfile) {
		return candidateProfileService.saveProfile(candidateProfile);
	}
	
	@GetMapping
	public List<CandidateProfile> getAllCandidates(){
		return candidateProfileService.getAllCandidates();
	}
	
	@GetMapping("/{id}")
	public CandidateProfile getCandidatesById(@PathVariable Long id) {
		return candidateProfileService.getCandidatesById(id);
	}
	
	

}
