package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CandidateProfile;

public interface CandidateProfileRepository extends JpaRepository<CandidateProfile,Long> {

}
