package com.example.JobApplicationTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class JobApplication{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @NotNull
        private long jobId;
        @NotNull
        private String company;
        @NotNull
        private String role;
        @NotNull
        private Date applicationDate;
        @NotNull
        private String jobUrl;
        @NotNull
        private String location;
}
