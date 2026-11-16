package com.example.JobApplicationTracker.dto;

import java.util.Date;

public record JobApplicationRequest(
    long jobId,
    String companyName,
    String jobRole,
    String location,
    Date applicationDate,
    String jobUrl
) {

}
