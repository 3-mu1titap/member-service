package com.multitap.member.application;

import com.multitap.member.dto.out.ProfileImageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, ProfileImageDto> kafkaProfileImageUrlTemplate;

    @Override
    public void sendCreateProfileImageUrl(ProfileImageDto profileImageDto) {
        try {
            kafkaProfileImageUrlTemplate.send("create-profile-image-topic", profileImageDto);
        }
        catch (Exception e) {
            log.info("create mentoring event send 실패 : " + e);
            throw new RuntimeException(e);
        }

    }
}
