package com.multitap.member.vo.in;

import com.multitap.member.entity.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MentorProfileRequestVo {

    @Schema(description = "멘토링 분야", example = "면접", nullable = true)
    private String mentoringField;

    @Schema(description = "나이", example = "27", nullable = true)
    private Integer age;

    @Schema(description = "성별", example = "FEMALE", nullable = true)
    private Gender gender;

    @Schema(description = "직무경험", example = "3년", nullable = true)
    private String jobExperience;

}