package com.multitap.member.application;

import com.multitap.member.dto.in.ReactionRequestDto;
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
    public List<TargetUuidResponseDto> getLikeTargetUuid(String uuid, Long cursorId, int size) {
        log.info("요청 확인:{},{},{}", uuid,cursorId,size);
        Pageable pageable = PageRequest.of(0, size);

        if (cursorId == null) {
            // 초기 호출: 최신 데이터 페이징 처리
            return reactionRepository.findByTargetUuidAndTypeTrueAndLikedTrue(uuid, pageable)
                    .stream()
                    .map(TargetUuidResponseDto::from)
                    .toList();
        } else {
            // 커서 기준 이전 데이터 페이징 처리
            return reactionRepository.findPreviousByTargetUuidAndTypeTrueAndLikedTrue(uuid, cursorId, pageable)
                    .stream()
                    .map(TargetUuidResponseDto::from)
                    .toList();
        }
    }

    @Override
    public List<TargetUuidResponseDto> getBlackTargetUuid(String uuid, Long cursorId, int size) {
        log.info("요청 확인:{},{},{}", uuid,cursorId,size);
        Pageable pageable = PageRequest.of(0, size);

        if (cursorId == null) {
            // 초기 호출: 최신 데이터 페이징 처리
            return reactionRepository.findByUuidAndTypeFalseAndLikedTrue(uuid, pageable)
                    .stream()
                    .map(TargetUuidResponseDto::from)
                    .toList();
        } else {
            // 커서 기준 이전 데이터 페이징 처리
            return reactionRepository.findPreviousByUuidAndTypeFalseAndLikedTrue(uuid, cursorId, pageable)
                    .stream()
                    .map(TargetUuidResponseDto::from)
                    .toList();
        }
    }
}
