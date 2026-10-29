package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CandidateProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CandidateProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateProfileService {
	private final CandidateProfileRepository candidateProfileRepository;
	
	public CandidateProfile saveProfile(CandidateProfile candidateProfile) {
		return candidateProfileRepository.save(candidateProfile);
	}
	
	public List<CandidateProfile> getAllCandidates(){
		return candidateProfileRepository.findAll();
	}
	public CandidateProfile getCandidatesById(Long id) {
		return candidateProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found"));
	}
	
	
	

}
