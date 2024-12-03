package com.multitap.member.vo.in;

import com.multitap.member.entity.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenteeProfileRequestVo {

    @Schema(description = "직업상태", example = "취준생", nullable = true)
    private String occupationStatus;

    @Schema(description = "최종학력", example = "초졸", nullable = true)
    private String educationLevel;

    @Schema(description = "생년월일", example = "1998-04-28", nullable = true)
    private String birthDate;

    @Schema(description = "성별", example = "FEMALE", nullable = true)
    private Gender gender;

    @Schema(description = "직무경험", example = "3년", nullable = true)
    private String jobExperience;

    @Schema(description = "직군", example = " IT", nullable = true)
    private String jobType;

    @Schema(description = "지원한 회사 수", example = "1", nullable = true)
    private Integer jobApplicationCount;

}
