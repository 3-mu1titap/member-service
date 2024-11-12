package com.multitap.member.dto.out;

import com.multitap.member.entity.Reaction;
import com.multitap.member.vo.out.LikeTargetUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeTargetUuidResponseDto {

    private String targetUuid;

    @Builder
    public LikeTargetUuidResponseDto(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    public static LikeTargetUuidResponseDto from(Reaction reaction) {
        return LikeTargetUuidResponseDto.builder()
                .targetUuid(reaction.getTargetUuid())
                .build();
    }

    public static LikeTargetUuidResponseVo toVo(LikeTargetUuidResponseDto likeTargetUuidResponseDto) {
        return LikeTargetUuidResponseVo.builder()
                .targetUuid(likeTargetUuidResponseDto.getTargetUuid())
                .build();
    }

}
