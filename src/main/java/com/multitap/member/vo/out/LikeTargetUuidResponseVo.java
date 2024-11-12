package com.multitap.member.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeTargetUuidResponseVo {

    private String targetUuid;

    @Builder
    public LikeTargetUuidResponseVo(String targetUuid) {
        this.targetUuid = targetUuid;
    }
}
