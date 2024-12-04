package com.multitap.member.application;

import com.multitap.member.dto.in.ReactionRequestDto;
import com.multitap.member.dto.out.LikedResponseDto;
import com.multitap.member.dto.out.TargetUuidResponseDto;
import com.multitap.member.entity.Reaction;
import com.multitap.member.infrastructure.ReactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReactionServiceImpl implements ReactionService {

    private final ReactionRepository reactionRepository;

    @Override
    public void toggleReaction(ReactionRequestDto reactionRequestDto) {

        Optional<Reaction> existingReaction = reactionRepository.findByUuidAndTargetUuidAndType(
                reactionRequestDto.getUuid(), reactionRequestDto.getTargetUuid(), reactionRequestDto.isType());

        reactionRepository.save(reactionRequestDto.toEntity(existingReaction.orElse(null)));
    }


    @Override
    public List<TargetUuidResponseDto> getLikeTargetUuid(String targetUuid, String cursorTargetUuid, int size) {
        Pageable pageable = PageRequest.of(0, size);

        if (cursorTargetUuid == null) {
            return reactionRepository.findByTargetUuidAndTypeTrueAndLikedTrue(targetUuid, pageable)
                    .stream()
                    .map(TargetUuidResponseDto::from)
                    .toList();
        } else {
            return reactionRepository.findPreviousByTargetUuidAndTypeTrueAndLikedTrue(cursorTargetUuid, pageable)
                    .stream()
                    .map(TargetUuidResponseDto::from)
                    .toList();
        }
    }


    @Override
    public List<TargetUuidResponseDto> getBlackTargetUuid(String uuid) {
        return reactionRepository.findByUuidAndTypeFalseAndLikedTrue(uuid)
                .stream()
                .map(TargetUuidResponseDto::from)
                .toList();
    }

    @Override
    public LikedResponseDto getLiked(String uuid, String targetUuid) {
        Reaction reaction = reactionRepository.findByUuidAndTargetUuidAndType(uuid, targetUuid, true)
                .orElse(null);

        if (reaction == null) {
            return LikedResponseDto.from(false);
        } else {
            return LikedResponseDto.from(reaction.isLiked());
        }
    }
}
