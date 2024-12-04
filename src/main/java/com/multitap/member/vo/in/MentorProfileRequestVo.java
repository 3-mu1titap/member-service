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

    @Schema(description = "생년월일", example = "1998-04-28", nullable = true)
    private String birthDate;

    @Schema(description = "성별", example = "FEMALE", nullable = true)
    private Gender gender;

    @Schema(description = "직무경험", example = "3년", nullable = true)
    private String jobExperience;

}