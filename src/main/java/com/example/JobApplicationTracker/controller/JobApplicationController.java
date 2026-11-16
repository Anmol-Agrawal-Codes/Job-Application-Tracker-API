package com.example.JobApplicationTracker.controller;

import com.example.JobApplicationTracker.dto.JobApplicationRequest;
import com.example.JobApplicationTracker.dto.JobApplicationResponse;
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

    @PostMapping("/create")
    public void createJobApplication(@Valid @RequestBody JobApplicationRequest jobApplicationRequest) {
        jobApplicationServiceImpl.createJobApplication(jobApplicationRequest);
    }

    @GetMapping(value = "/get", params = {"company"})
    public List<JobApplicationResponse> getJobApplicationByCompany(@RequestParam String company) {
        return jobApplicationServiceImpl.getJobApplicationsByCompany(company);
    }

    @GetMapping(value = "/get", params = {"jobId"})
    public JobApplicationResponse getJobApplicationById(@RequestParam long jobId) {
        return jobApplicationServiceImpl.getJobApplicationByJobId(jobId);
    }

    @DeleteMapping("/delete")
    public void deleteJobApplicationById(@RequestParam long jobId) {
        jobApplicationServiceImpl.deleteJobApplicationByJobId(jobId);
    }

    @PatchMapping(value = "/update", params = {"jobId"})
    public JobApplicationResponse patchJobApplication(
            @PathVariable long jobId,
            @RequestBody JobApplicationRequest jobApplicationRequest) {

        return jobApplicationServiceImpl.updateJobApplicationByJobId(jobId, jobApplicationRequest);
    }
}
