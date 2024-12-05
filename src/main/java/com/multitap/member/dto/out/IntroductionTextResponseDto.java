package com.multitap.member.dto.out;

import com.multitap.member.entity.IntroductionText;
import com.multitap.member.vo.out.IntroductionTextResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IntroductionTextResponseDto {

    private String content;

    @Builder
    public IntroductionTextResponseDto(String content) {
        this.content = content;
    }

    public static IntroductionTextResponseDto from(IntroductionText introductionText){
        return IntroductionTextResponseDto.builder()
                .content(introductionText.getContent())
                .build();
    }

    public IntroductionTextResponseVo toVo( ){
        return IntroductionTextResponseVo.builder()
                .content(content)
                .build();
    }

}
