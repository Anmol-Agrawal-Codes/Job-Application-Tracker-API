package com.example.JobApplicationTracker.dto;

import com.example.JobApplicationTracker.enums.ApplicationStatus;

import java.time.LocalDate;

public record JobApplicationResponse (
    Long jobId,
    String companyName,
    String jobRole,
    ApplicationStatus applicationStatus,
    String location,
    LocalDate applicationDate
){
}
