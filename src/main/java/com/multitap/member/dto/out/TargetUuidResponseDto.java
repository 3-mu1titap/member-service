package com.multitap.member.dto.out;

import com.multitap.member.entity.Reaction;
import com.multitap.member.vo.out.TargetUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TargetUuidResponseDto {

    private String targetUuid;

    @Builder
    public TargetUuidResponseDto(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    public static TargetUuidResponseDto from(Reaction reaction) {
        return TargetUuidResponseDto.builder()
                .targetUuid(reaction.getTargetUuid())
                .build();
    }

    public static TargetUuidResponseVo toVo(TargetUuidResponseDto likeTargetUuidResponseDto) {
        return TargetUuidResponseVo.builder()
                .targetUuid(likeTargetUuidResponseDto.getTargetUuid())
                .build();
    }

}
