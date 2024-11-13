package com.multitap.member.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendCreateProfileImageUrl(ProfileImageDto profileImageDto) {
        try {
            kafkaTemplate.send("create-profile-image-topic", profileImageDto);
        } catch (Exception e) {
            log.info("create profile Image event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendCreateMentorProfile(MentorProfileDto mentorProfileDto) {

        try {
            kafkaTemplate.send("create-mentor-profile-topic", mentorProfileDto);
        } catch (Exception e) {
            log.info("create mentor profile event send 실패 : " + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendCreateMenteeProfile(MenteeProfileDto menteeProfileDto) {
        try {
            kafkaTemplate.send("create-mentee-profile-topic", menteeProfileDto);
        } catch (Exception e) {
            log.info("create mentee profile event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendCreateHashTag(List<HashtagDto> hashTagDto) {
        try {
            kafkaTemplate.send("create-hashtag-topic", hashTagDto);
        } catch (Exception e) {
            log.info("create hashtag event send 실패 : " + e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendCreateReaction(ReactionDto reactionDto) {
        try {
            kafkaTemplate.send("create-reaction-topic", reactionDto);
        } catch (Exception e) {
            log.info("create reaction event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }
}
