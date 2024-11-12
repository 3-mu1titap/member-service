package com.multitap.member.application;

import com.multitap.member.dto.in.ReactionRequestDto;
import com.multitap.member.dto.out.LikeTargetUuidResponseDto;

import java.util.List;

public interface ReactionService {
    void toggleReaction(ReactionRequestDto reactionRequestDto);
    List<LikeTargetUuidResponseDto> getLikeTargetUuid(String uuid);
}
