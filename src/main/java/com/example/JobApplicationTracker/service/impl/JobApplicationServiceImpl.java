package com.example.JobApplicationTracker.service.impl;

import com.example.JobApplicationTracker.dto.JobApplicationRequest;
import com.example.JobApplicationTracker.dto.JobApplicationResponse;
import com.example.JobApplicationTracker.entity.JobApplication;
import com.example.JobApplicationTracker.errors.ApplicationNotFoundException;
import com.example.JobApplicationTracker.repository.JobApplicationRepository;
import com.example.JobApplicationTracker.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    @Autowired
    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public void createJobApplication(JobApplicationRequest jobApplicationRequest) {
        long jobId = jobApplicationRequest.jobId();
        String company = jobApplicationRequest.companyName();
        String jobRole = jobApplicationRequest.jobRole();
        Date applicationDate = jobApplicationRequest.applicationDate();
        String url = jobApplicationRequest.jobUrl();
        String location = jobApplicationRequest.location();

        JobApplication jobApplication = new JobApplication();
        jobApplication.setJobId(jobId);
        jobApplication.setCompany(company);
        jobApplication.setApplicationDate(applicationDate);
        jobApplication.setJobUrl(url);
        jobApplication.setLocation(location);
        jobApplication.setRole(jobRole);

        jobApplicationRepository.save(jobApplication);
    }

    public List<JobApplicationResponse> getJobApplicationsByCompany(String company) {
        List<JobApplication> jobApplications = jobApplicationRepository.findByCompany(company);

        if (jobApplications.isEmpty()) {
            throw new ApplicationNotFoundException("No Application Found for company: " + company);
        }

        List<JobApplicationResponse> jobApplicationResponseList = new ArrayList<>();

        for (JobApplication jobApplication : jobApplications) {
            JobApplicationResponse jobApplicationResponse = new JobApplicationResponse(
                    jobApplication.getJobId(),
                    jobApplication.getCompany(),
                    jobApplication.getLocation(),
                    jobApplication.getApplicationDate()
            );

            jobApplicationResponseList.add(jobApplicationResponse);
        }

        return jobApplicationResponseList;
    }

    public JobApplicationResponse getJobApplicationByJobId(long jobId) {
        JobApplication jobApplication = jobApplicationRepository.findByJobId(jobId);
        if (jobApplication == null) {
            throw new ApplicationNotFoundException("No Application Found with id: " + jobId);
        }

        JobApplicationResponse jobApplicationResponse = new JobApplicationResponse(
                jobApplication.getJobId(),
                jobApplication.getRole(),
                jobApplication.getLocation(),
                jobApplication.getApplicationDate()
        );
        return jobApplicationResponse;
    }

    public void deleteJobApplicationByJobId(long jobId) {
        jobApplicationRepository.deleteByJobId(jobId);
    }

    public List<JobApplication> findAll() {
        return jobApplicationRepository.findAll();
    }
}
