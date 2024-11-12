package com.multitap.member.application;

import com.multitap.member.dto.in.ReactionRequestDto;
import com.multitap.member.dto.out.TargetUuidResponseDto;

import java.util.List;

public interface ReactionService {
    void toggleReaction(ReactionRequestDto reactionRequestDto);
    List<TargetUuidResponseDto> getLikeTargetUuid(String uuid);
    List<TargetUuidResponseDto> getBlackTargetUuid(String uuid);
}
