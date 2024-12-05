package com.multitap.member.dto.out;

import com.multitap.member.entity.Reaction;
import com.multitap.member.vo.out.TargetUuidResponseVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TargetUuidResponseDto {

    private Long id;
    private String targetUuid;

    @Builder
    public TargetUuidResponseDto(Long id, String targetUuid) {
        this.id = id;
        this.targetUuid = targetUuid;
    }

    public static TargetUuidResponseDto from(Reaction reaction) {
        return TargetUuidResponseDto.builder()
                .id(reaction.getId())
                .targetUuid(reaction.getTargetUuid())
                .build();
    }

    public static TargetUuidResponseVo toVo(TargetUuidResponseDto likeTargetUuidResponseDto) {
        return TargetUuidResponseVo.builder()
                .id(likeTargetUuidResponseDto.getId())
                .targetUuid(likeTargetUuidResponseDto.getTargetUuid())
                .build();
    }

}
