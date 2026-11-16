package com.example.JobApplicationTracker.repository;

import com.example.JobApplicationTracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByCompany(String company);
    JobApplication findByJobId(long jobId);
    void deleteByJobId(long jobId);
    List<JobApplication> findByLocation(String location);
}
