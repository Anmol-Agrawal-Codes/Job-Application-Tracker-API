package com.example.JobApplicationTracker.service.impl;

import com.example.JobApplicationTracker.dto.JobApplicationRequest;
import com.example.JobApplicationTracker.dto.JobApplicationResponse;
import com.example.JobApplicationTracker.entity.JobApplication;
import com.example.JobApplicationTracker.errors.ApplicationNotFoundException;
import com.example.JobApplicationTracker.repository.JobApplicationRepository;
import com.example.JobApplicationTracker.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        LocalDate applicationDate = jobApplicationRequest.applicationDate();
        String url = jobApplicationRequest.jobUrl();
        String location = jobApplicationRequest.location();

        JobApplication jobApplication = new JobApplication();
        jobApplication.setJobId(jobId);
        jobApplication.setCompany(company);
        jobApplication.setApplicationDate(applicationDate);
        jobApplication.setJobUrl(url);
        jobApplication.setLocation(location);
        jobApplication.setJobRole(jobRole);

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
                    jobApplication.getJobRole(),
                    jobApplication.getLocation(),
                    jobApplication.getApplicationDate()
            );

            jobApplicationResponseList.add(jobApplicationResponse);
        }

        return jobApplicationResponseList;
    }

    public List<JobApplicationResponse> getAllJobApplications() {
        List<JobApplication> jobApplications = jobApplicationRepository.findAll();

        if (jobApplications.isEmpty()) {
            throw new ApplicationNotFoundException("No Job Application Found");
        }

        List<JobApplicationResponse> jobApplicationResponseList = new ArrayList<>();

        for (JobApplication jobApplication : jobApplications) {
            JobApplicationResponse jobApplicationResponse = new JobApplicationResponse(
                    jobApplication.getJobId(),
                    jobApplication.getCompany(),
                    jobApplication.getJobRole(),
                    jobApplication.getLocation(),
                    jobApplication.getApplicationDate()
            );
            jobApplicationResponseList.add(jobApplicationResponse);
        }
        return jobApplicationResponseList;
    }

    public List<JobApplicationResponse> getJobApplicationsByLocation(String location) {
        List<JobApplication> jobApplications = jobApplicationRepository.findByLocation(location);

        if (jobApplications.isEmpty()) {
            throw new ApplicationNotFoundException("No Job Application Found");
        }

        List<JobApplicationResponse> jobApplicationResponseList = new ArrayList<>();

        for (JobApplication jobApplication : jobApplications) {
            JobApplicationResponse jobApplicationResponse = new JobApplicationResponse(
                    jobApplication.getJobId(),
                    jobApplication.getCompany(),
                    jobApplication.getJobRole(),
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

        return new JobApplicationResponse(
                jobApplication.getJobId(),
                jobApplication.getCompany(),
                jobApplication.getJobRole(),
                jobApplication.getLocation(),
                jobApplication.getApplicationDate()
        );
    }

    public void deleteJobApplicationByJobId(long jobId) {
        if(getJobApplicationByJobId(jobId) == null) {
            throw new ApplicationNotFoundException("No Application Found with id: " + jobId);
        }
        jobApplicationRepository.deleteByJobId(jobId);
    }

    public JobApplicationResponse updateJobApplicationByJobId(long jobId, JobApplicationRequest jobApplicationRequest) {
        JobApplication jobApplication = jobApplicationRepository.findByJobId(jobId);
        if (jobApplication == null) {
            throw new ApplicationNotFoundException("No Application Found with id: " + jobId);
        }

        if (jobApplicationRequest.jobId() != null) {
            jobApplication.setJobId(jobApplicationRequest.jobId());
        }
        if (jobApplicationRequest.companyName() != null) {
            jobApplication.setCompany(jobApplicationRequest.companyName());
        }
        if (jobApplicationRequest.jobRole() != null) {
            jobApplication.setJobRole(jobApplicationRequest.jobRole());
        }
        if (jobApplicationRequest.applicationDate() != null) {
            jobApplication.setApplicationDate(jobApplicationRequest.applicationDate());
        }
        if (jobApplicationRequest.jobUrl() != null) {
            jobApplication.setJobUrl(jobApplicationRequest.jobUrl());
        }
        if (jobApplicationRequest.location() != null) {
            jobApplication.setLocation(jobApplicationRequest.location());
        }

        jobApplicationRepository.save(jobApplication);
        return getJobApplicationByJobId(jobApplication.getJobId());
    }
}
