package com.multitap.member.kafka.producer;

import com.multitap.member.entity.Gender;
import com.multitap.member.entity.MentorProfile;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MentorProfileDto {
    private String uuid;
    private String mentoringField;
    private Integer age;
    private Gender gender;
    private String jobExperience;

    @Builder
    public MentorProfileDto(String uuid, String mentoringField, Integer age, Gender gender, String jobExperience) {
        this.uuid = uuid;
        this.mentoringField = mentoringField;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
    }

    public static MentorProfileDto from(MentorProfile mentorProfile) {
        return MentorProfileDto.builder()
                .uuid(mentorProfile.getUuid())
                .mentoringField(mentorProfile.getMentoringField())
                .age(mentorProfile.getAge())
                .gender(mentorProfile.getGender())
                .jobExperience(mentorProfile.getJobExperience())
                .build();
    }

}
