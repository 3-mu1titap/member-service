package com.multitap.member.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TargetUuidResponseVo {

    private Long id;
    private String targetUuid;

    @Builder
    public TargetUuidResponseVo(Long id, String targetUuid) {
        this.id = id;
        this.targetUuid = targetUuid;
    }
}
