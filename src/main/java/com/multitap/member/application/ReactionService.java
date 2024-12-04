package com.multitap.member.application;

import com.multitap.member.dto.in.ReactionRequestDto;
import com.multitap.member.dto.out.LikedResponseDto;
import com.multitap.member.dto.out.TargetUuidResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ReactionService {
    void toggleReaction(ReactionRequestDto reactionRequestDto);
    List<TargetUuidResponseDto> getLikeTargetUuid(String targetUuid, String cursorTargetUuid, int size);
    List<TargetUuidResponseDto> getBlackTargetUuid(String uuid);
    LikedResponseDto getLiked(String uuid,String targetUuid);
}
