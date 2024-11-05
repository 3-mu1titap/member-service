package com.multitap.member.application;

import com.multitap.member.dto.out.ProfileImageDto;

public interface KafkaProducerService {
    void sendCreateProfileImageUrl(ProfileImageDto profileImageDto);
}
