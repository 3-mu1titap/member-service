package com.multitap.member.kafka.consumer;

import com.multitap.member.entity.Reaction;
import com.multitap.member.infrastructure.ReactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private final ReactionRepository reactionRepository;

    @KafkaListener(topics = "member-data", containerFactory = "memberUuidDtoListener")
    public void processReactionData(MemberUuidDataDto memberUuidDataDto) {
        List<String> menteeUuids = memberUuidDataDto.getMenteeUuid();
        List<String> mentorUuids = memberUuidDataDto.getMentorUuid();

        Random random = new Random();

        List<Reaction> reactions = new ArrayList<>();

        for (String mentorUuid : mentorUuids) {
            // 멘토마다 랜덤한 수의 멘티에게 좋아요를 부여
            int numberOfLikes = random.nextInt(menteeUuids.size()) + 1; // 1명 이상에게 좋아요
            List<String> selectedMentees = getRandomElements(menteeUuids, numberOfLikes, random);

            for (String menteeUuid : selectedMentees) {
                Reaction reaction = Reaction.builder()
                        .uuid(menteeUuid)
                        .targetUuid(mentorUuid)
                        .type(true) // 좋아요 타입
                        .liked(true) // 좋아요 상태
                        .build();

                reactions.add(reaction);
            }
        }

        reactionRepository.saveAll(reactions);
    }

    private List<String> getRandomElements(List<String> list, int count, Random random) {
        List<String> copy = new ArrayList<>(list);
        List<String> selected = new ArrayList<>();
        for (int i = 0; i < count && !copy.isEmpty(); i++) {
            int index = random.nextInt(copy.size());
            selected.add(copy.remove(index));
        }
        return selected;
    }
}
