package com.example.JobApplicationTracker.controller;

import com.example.JobApplicationTracker.dto.JobApplicationRequest;
import com.example.JobApplicationTracker.dto.JobApplicationResponse;
import com.example.JobApplicationTracker.dto.UpdatedJobApplicationStatus;
import com.example.JobApplicationTracker.enums.ApplicationStatus;
import com.example.JobApplicationTracker.service.JobApplicationService;
import com.example.JobApplicationTracker.service.impl.JobApplicationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobApplication")
public class JobApplicationController {

    private final JobApplicationService jobApplicationServiceImpl;

    @Autowired
    public JobApplicationController(JobApplicationServiceImpl jobApplicationServiceImpl) {
        this.jobApplicationServiceImpl = jobApplicationServiceImpl;
    }

    @PostMapping("/createApplication")
    public void createJobApplication(@Valid @RequestBody JobApplicationRequest jobApplicationRequest) {
        jobApplicationServiceImpl.createJobApplication(jobApplicationRequest);
    }

    @GetMapping(value = "/getApplication", params = {"company"})
    public List<JobApplicationResponse> getJobApplicationByCompany(@RequestParam String company) {
        return jobApplicationServiceImpl.getJobApplicationsByCompany(company);
    }

    @GetMapping(value = "/getApplication", params = {"jobId"})
    public JobApplicationResponse getJobApplicationById(@RequestParam long jobId) {
        return jobApplicationServiceImpl.getJobApplicationByJobId(jobId);
    }

    @GetMapping(value = "/getApplication")
    public List<JobApplicationResponse> getAllJobApplications() {
        return jobApplicationServiceImpl.getAllJobApplications();
    }

    @GetMapping(value = "/getApplication", params = {"location"})
    public List<JobApplicationResponse> getAllJobApplicationsByLocation(String location) {
        return jobApplicationServiceImpl.getJobApplicationsByLocation(location);
    }

    @DeleteMapping("/deleteApplication")
    public void deleteJobApplicationById(@RequestParam long jobId) {
        jobApplicationServiceImpl.deleteJobApplicationByJobId(jobId);
    }

    @PatchMapping(value = "/updateApplication", params = {"jobId"})
    public JobApplicationResponse patchJobApplication(
            @RequestParam long jobId,
            @RequestBody JobApplicationRequest jobApplicationRequest) {
        return jobApplicationServiceImpl.updateJobApplicationByJobId(jobId, jobApplicationRequest);
    }

    @PatchMapping(value = "/updateApplicationStatus", params = {"jobId"})
    public UpdatedJobApplicationStatus updateJobApplicationStatusByJobId(@RequestParam long jobId, @Valid @RequestBody UpdatedJobApplicationStatus applicationStatus) {
        return jobApplicationServiceImpl.updateJobApplicationStatusByJobId(jobId, applicationStatus);
    }
}
