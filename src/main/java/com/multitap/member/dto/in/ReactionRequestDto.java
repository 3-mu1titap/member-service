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

    @Builder
    public ReactionRequestDto(String uuid, String targetUuid, boolean type) {
        this.uuid = uuid;
        this.targetUuid = targetUuid;
        this.type = type;
    }

    public static ReactionRequestDto from(ReactionRequestVo reactionRequestVo, String targetUuid, String uuid) {
        return ReactionRequestDto.builder()
                .targetUuid(targetUuid)
                .uuid(uuid)
                .type(reactionRequestVo.isType())
                .build();
    }

    public Reaction toEntity(Reaction reaction) {
        return Reaction.builder()
                .id(reaction != null ? reaction.getId() : null)
                .uuid(this.uuid)
                .targetUuid(this.targetUuid)
                .type(this.type)
                .liked(reaction != null && !reaction.isLiked())
                .build();
    }

    public Reaction updateToEntity(ReactionRequestDto reactionRequestDto, Reaction reaction) {
        return Reaction.builder()
                .id(reaction.getId())
                .uuid(reactionRequestDto.getUuid())
                .targetUuid(reactionRequestDto.getTargetUuid())
                .type(reactionRequestDto.isType())
                .liked(!reaction.isLiked())
                .build();
    }

}
