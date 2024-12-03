package com.multitap.member.dto.in;

import com.multitap.member.entity.Gender;
import com.multitap.member.entity.MentorProfile;
import com.multitap.member.vo.in.MentorProfileRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class MentorProfileRequestDto {

    private String uuid;
    private String mentoringField;
    private Integer age;
    private Gender gender;
    private String jobExperience;

    @Builder
    public MentorProfileRequestDto(String uuid, String mentoringField, Integer age, Gender gender, String jobExperience) {
        this.uuid = uuid;
        this.mentoringField = mentoringField;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
    }

    public static MentorProfileRequestDto from(MentorProfileRequestVo mentorProfileRequestVo, String uuid) {
        return MentorProfileRequestDto.builder()
                .uuid(uuid)
                .mentoringField(mentorProfileRequestVo.getMentoringField())
                .age(createAge(mentorProfileRequestVo.getBirthDate()))
                .gender(mentorProfileRequestVo.getGender())
                .jobExperience(mentorProfileRequestVo.getJobExperience())
                .build();
    }

    public MentorProfile toEntity(MentorProfileRequestDto mentorProfileRequestDto) {
        return MentorProfile.builder()
                .uuid(mentorProfileRequestDto.getUuid())
                .mentoringField(mentorProfileRequestDto.getMentoringField())
                .age(mentorProfileRequestDto.getAge())
                .gender(mentorProfileRequestDto.getGender())
                .jobExperience(mentorProfileRequestDto.getJobExperience())
                .build();
    }

    public MentorProfile updateToEntity(MentorProfileRequestDto mentorProfileRequestDto, MentorProfile mentorProfile) {
        return MentorProfile.builder()
                .id(mentorProfile.getId())
                .uuid(mentorProfileRequestDto.getUuid())
                .mentoringField(mentorProfileRequestDto.getMentoringField())
                .age(mentorProfileRequestDto.getAge())
                .gender(mentorProfileRequestDto.getGender())
                .jobExperience(mentorProfileRequestDto.getJobExperience())
                .build();
    }

    //나이 계산
    public static Integer createAge(String birthDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthdate = LocalDate.parse(birthDate, formatter);

        LocalDate currentDate = LocalDate.now();

        return currentDate.getYear() - birthdate.getYear();
    }

}
