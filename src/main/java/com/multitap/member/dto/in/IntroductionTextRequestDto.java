package com.multitap.member.dto.in;

import com.multitap.member.entity.IntroductionText;
import com.multitap.member.vo.in.IntroductionRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IntroductionTextRequestDto {

    private String uuid;
    private String content;

    @Builder
    public IntroductionTextRequestDto(String uuid, String content) {
        this.uuid = uuid;
        this.content = content;
    }


    public static IntroductionTextRequestDto from(String uuid, IntroductionRequestVo introductionRequestVo){
        return IntroductionTextRequestDto.builder()
                .uuid(uuid)
                .content(introductionRequestVo.getContent())
                .build();
    }

    public IntroductionText toEntity(IntroductionTextRequestDto introductionTextRequestDto){
        return IntroductionText.builder()
                .uuid(introductionTextRequestDto.getUuid())
                .content(introductionTextRequestDto.getContent())
                .build();
    }

}
