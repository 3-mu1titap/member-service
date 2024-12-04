package com.multitap.member.dto.in;

import com.multitap.member.entity.Gender;
import com.multitap.member.entity.MenteeProfile;
import com.multitap.member.vo.in.MenteeProfileRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class MenteeProfileRequestDto {

    private String uuid;
    private String occupationStatus;
    private String educationLevel;
    private Integer age;
    private Gender gender;
    private String jobExperience;
    private String jobType;
    private Integer jobApplicationCount;

    @Builder
    public MenteeProfileRequestDto(String uuid, String occupationStatus, String educationLevel, Integer age, Gender gender, String jobExperience, String jobType, Integer jobApplicationCount) {
        this.uuid = uuid;
        this.occupationStatus = occupationStatus;
        this.educationLevel = educationLevel;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
        this.jobType = jobType;
        this.jobApplicationCount = jobApplicationCount;
    }

    public static MenteeProfileRequestDto from(MenteeProfileRequestVo menteeProfileRequestVo, String uuid) {
        return MenteeProfileRequestDto.builder()
                .uuid(uuid)
                .occupationStatus(menteeProfileRequestVo.getOccupationStatus())
                .educationLevel(menteeProfileRequestVo.getEducationLevel())
                .age(createAge(menteeProfileRequestVo.getBirthDate()))
                .gender(menteeProfileRequestVo.getGender())
                .jobExperience(menteeProfileRequestVo.getJobExperience())
                .jobType(menteeProfileRequestVo.getJobType())
                .jobApplicationCount(menteeProfileRequestVo.getJobApplicationCount())
                .build();
    }

    public MenteeProfile toEntity(MenteeProfileRequestDto menteeProfileRequestDto) {
        return MenteeProfile.builder()
                .uuid(menteeProfileRequestDto.getUuid())
                .occupationStatus(menteeProfileRequestDto.getOccupationStatus())
                .educationLevel(menteeProfileRequestDto.getEducationLevel())
                .age(menteeProfileRequestDto.getAge())
                .gender(menteeProfileRequestDto.getGender())
                .jobExperience(menteeProfileRequestDto.getJobExperience())
                .jobType(menteeProfileRequestDto.getJobType())
                .jobApplicationCount(menteeProfileRequestDto.getJobApplicationCount())
                .build();

    }

    public MenteeProfile updateToEntity(MenteeProfileRequestDto menteeProfileRequestDto, MenteeProfile menteeProfile) {
        return MenteeProfile.builder()
                .id(menteeProfile.getId())
                .uuid(menteeProfileRequestDto.getUuid())
                .occupationStatus(menteeProfileRequestDto.getOccupationStatus())
                .educationLevel(menteeProfileRequestDto.getEducationLevel())
                .age(menteeProfileRequestDto.getAge())
                .gender(menteeProfileRequestDto.getGender())
                .jobExperience(menteeProfileRequestDto.getJobExperience())
                .jobType(menteeProfileRequestDto.getJobType())
                .jobApplicationCount(menteeProfileRequestDto.getJobApplicationCount())
                .build();

    }

    public static Integer createAge(String birthDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(birthDate, formatter);

        LocalDate currentDate = LocalDate.now();

        return currentDate.getYear() - birthdate.getYear();
    }



}
