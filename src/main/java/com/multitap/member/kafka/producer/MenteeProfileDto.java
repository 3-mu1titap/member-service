package com.multitap.member.kafka.producer;

import com.multitap.member.entity.Gender;
import com.multitap.member.entity.MenteeProfile;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenteeProfileDto {

    private String uuid;
    private String occupationStatus;
    private String educationLevel;
    private Integer age;
    private Gender gender;
    private String jobExperience;
    private String jobType;
    private Integer jobApplicationCount;

    @Builder
    public MenteeProfileDto(String uuid, String occupationStatus, String educationLevel, Integer age, Gender gender, String jobExperience, String jobType, Integer jobApplicationCount) {
        this.uuid = uuid;
        this.occupationStatus = occupationStatus;
        this.educationLevel = educationLevel;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
        this.jobType = jobType;
        this.jobApplicationCount = jobApplicationCount;
    }

    public static MenteeProfileDto from(MenteeProfile menteeProfile) {
        return MenteeProfileDto.builder()
                .uuid(menteeProfile.getUuid())
                .occupationStatus(menteeProfile.getOccupationStatus())
                .educationLevel(menteeProfile.getEducationLevel())
                .age(menteeProfile.getAge())
                .gender(menteeProfile.getGender())
                .jobExperience(menteeProfile.getJobExperience())
                .jobType(menteeProfile.getJobType())
                .jobApplicationCount(menteeProfile.getJobApplicationCount())
                .build();
    }

}
