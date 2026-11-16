package com.example.JobApplicationTracker.service;

import com.example.JobApplicationTracker.dto.JobApplicationRequest;
import com.example.JobApplicationTracker.dto.JobApplicationResponse;
import com.example.JobApplicationTracker.entity.JobApplication;
import com.example.JobApplicationTracker.enums.ApplicationStatus;

import java.util.List;

public interface JobApplicationService {

    void createJobApplication(JobApplicationRequest jobApplicationRequest);
    List<JobApplicationResponse> getJobApplicationsByCompany(String company);
    List<JobApplicationResponse> getJobApplicationsByLocation(String location);
    List<JobApplicationResponse> getAllJobApplications();
    JobApplicationResponse getJobApplicationByJobId(long jobId);
    void deleteJobApplicationByJobId(long jobId);
    JobApplicationResponse updateJobApplicationByJobId(long jobId, JobApplicationRequest jobApplicationRequest);

    void updateJobApplicationStatusByJobId(long jobId, ApplicationStatus applicationStatus);
}

