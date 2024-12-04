package com.multitap.member.vo.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageRequestVo {

    private String profileImageUrl;

    @Builder
    public ProfileImageRequestVo(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
