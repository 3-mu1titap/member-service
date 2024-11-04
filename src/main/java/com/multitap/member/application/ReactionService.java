package com.multitap.member.application;

import com.multitap.member.dto.in.ReactionRequestDto;

public interface ReactionService {
    void toggleReaction(ReactionRequestDto reactionRequestDto);
}
