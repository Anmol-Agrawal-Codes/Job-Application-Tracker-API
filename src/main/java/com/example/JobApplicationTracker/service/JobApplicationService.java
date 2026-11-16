package com.example.JobApplicationTracker.service;

import com.example.JobApplicationTracker.dto.JobApplicationRequest;
import com.example.JobApplicationTracker.dto.JobApplicationResponse;
import com.example.JobApplicationTracker.entity.JobApplication;

import java.util.List;

public interface JobApplicationService {

    void createJobApplication(JobApplicationRequest jobApplicationRequest);
    List<JobApplicationResponse> getJobApplicationsByCompany(String company);
    JobApplicationResponse getJobApplicationByJobId(long jobId);
    void deleteJobApplicationByJobId(long jobId);
    JobApplicationResponse updateJobApplicationByJobId(long jobId, JobApplicationRequest jobApplicationRequest);
}

