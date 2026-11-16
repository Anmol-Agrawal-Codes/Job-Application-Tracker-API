package com.example.JobApplicationTracker.entity;

import com.example.JobApplicationTracker.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class JobApplication{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long jobId;
        private String company;
        private String jobRole;
        private LocalDate applicationDate;
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private ApplicationStatus applicationStatus;
        private String jobUrl;
        private String location;
}
