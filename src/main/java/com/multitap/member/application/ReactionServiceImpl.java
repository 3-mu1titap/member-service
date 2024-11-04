package com.multitap.member.application;

import com.multitap.member.dto.in.ReactionRequestDto;
import com.multitap.member.entity.Reaction;
import com.multitap.member.infrastructure.ReactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private final ReactionRepository reactionRepository;

    @Override
    public void toggleReaction(ReactionRequestDto reactionRequestDto) {

        Optional<Reaction> reaction = reactionRepository.findByUuidAndTargetUuidAndType(reactionRequestDto.getUuid(), reactionRequestDto.getTargetUuid(), reactionRequestDto.isType());

        reaction.ifPresentOrElse(
                existingReaction -> reactionRepository.save(reactionRequestDto.updateToEntity(reactionRequestDto, existingReaction)),
                () -> reactionRepository.save(reactionRequestDto.toEntity(reactionRequestDto))
        );
    }
}

