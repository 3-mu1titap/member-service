package com.multitap.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenteeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String occupationStatus;

    @Column(nullable = false)
    private String educationLevel;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String jobExperience;

    @Column(nullable = false)
    private String jobType;

    @Column(nullable = false)
    private Integer jobApplicationCount;

    @Builder
    public MenteeProfile(Long id, String uuid, String occupationStatus, String educationLevel, Integer age, Gender gender, String jobExperience, String jobType, Integer jobApplicationCount) {
        this.id = id;
        this.uuid = uuid;
        this.occupationStatus = occupationStatus;
        this.educationLevel = educationLevel;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
        this.jobType = jobType;
        this.jobApplicationCount = jobApplicationCount;
    }
}
