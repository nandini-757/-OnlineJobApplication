package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.JobOpenings;

public interface JobOpeningsRepository extends JpaRepository<JobOpenings,Long> {

}
