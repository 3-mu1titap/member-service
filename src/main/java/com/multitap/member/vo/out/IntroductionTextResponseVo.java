package com.multitap.member.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IntroductionTextResponseVo {

    private String content;

    @Builder
    public IntroductionTextResponseVo(String content) {
        this.content = content;
    }

}
