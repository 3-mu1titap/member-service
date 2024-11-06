package com.multitap.member.infrastructure.kafka.producer;

import com.multitap.member.entity.Reaction;

import java.util.List;

public interface KafkaProducerService {
    // 프로필 관련 메시지 전송
    void sendCreateProfileImageUrl(ProfileImageDto profileImageDto);
    void sendCreateMentorProfile(MentorProfileDto mentorProfileDto);
    void sendCreateMenteeProfile(MenteeProfileDto menteeProfileDto);

    // 해시태그 관련 메시지 전송
    void sendCreateHashTag(List<HashtagDto> hashTagDto);

    // 블랙리스트/관심회원 메시지 전송
    void sendCreateReaction(ReactionDto reactionDto);

}
