package com.multitap.member.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TargetUuidResponseVo {

    private String targetUuid;

    @Builder
    public TargetUuidResponseVo(String targetUuid) {
        this.targetUuid = targetUuid;
    }
}
