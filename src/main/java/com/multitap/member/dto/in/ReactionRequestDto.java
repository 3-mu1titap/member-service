package com.multitap.member.dto.in;

import com.multitap.member.entity.Reaction;
import com.multitap.member.vo.in.ReactionRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReactionRequestDto {

    private String uuid;
    private String targetUuid;
    private boolean type;
    private boolean liked;

    @Builder
    public ReactionRequestDto(String uuid, String targetUuid, boolean type, boolean liked) {
        this.uuid = uuid;
        this.targetUuid = targetUuid;
        this.type = type;
        this.liked = liked;
    }

    public static ReactionRequestDto from(ReactionRequestVo reactionRequestVo, String targetUuid, String uuid) {
        return ReactionRequestDto.builder()
                .targetUuid(targetUuid)
                .uuid(uuid)
                .type(reactionRequestVo.isType())
                .liked(reactionRequestVo.isLiked())
                .build();
    }

    public Reaction toEntity(ReactionRequestDto reactionRequestDto) {
        return Reaction.builder()
                .uuid(reactionRequestDto.getUuid())
                .targetUuid(reactionRequestDto.getTargetUuid())
                .type(reactionRequestDto.isType())
                .liked(reactionRequestDto.isLiked())
                .build();
    }

    public Reaction updateToEntity(ReactionRequestDto reactionRequestDto, Reaction reaction) {
        return Reaction.builder()
                .id(reaction.getId())
                .uuid(reactionRequestDto.getUuid())
                .targetUuid(reactionRequestDto.getTargetUuid())
                .type(reactionRequestDto.isType())
                .liked(!reactionRequestDto.isLiked())
                .build();
    }

}
