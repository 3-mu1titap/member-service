package com.multitap.member.application;

import com.multitap.member.dto.in.ReactionRequestDto;
import com.multitap.member.dto.out.LikeTargetUuidResponseDto;
import com.multitap.member.entity.Reaction;
import com.multitap.member.infrastructure.ReactionRepository;
import com.multitap.member.kafka.producer.KafkaProducerService;
import com.multitap.member.kafka.producer.ReactionDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReactionServiceImpl implements ReactionService {

    private final ReactionRepository reactionRepository;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void toggleReaction(ReactionRequestDto reactionRequestDto) {

        Optional<Reaction> reaction = reactionRepository.findByUuidAndTargetUuidAndType(
                reactionRequestDto.getUuid(), reactionRequestDto.getTargetUuid(), reactionRequestDto.isType());

        Reaction savedReaction = reaction.map(existingReaction ->
                reactionRepository.save(reactionRequestDto.updateToEntity(reactionRequestDto, existingReaction))
        ).orElseGet(() ->
                reactionRepository.save(reactionRequestDto.toEntity(reactionRequestDto))
        );
        kafkaProducerService.sendCreateReaction(ReactionDto.from(savedReaction));
    }

    @Override
    public List<LikeTargetUuidResponseDto> getLikeTargetUuid(String uuid) {
        return reactionRepository.findByUuidAndTypeTrueAndLikedTrue(uuid)
                .stream()
                .map(LikeTargetUuidResponseDto::from)
                .toList();
    }
}
