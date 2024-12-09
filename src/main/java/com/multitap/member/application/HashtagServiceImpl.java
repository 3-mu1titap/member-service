package com.multitap.member.application;

import com.multitap.member.dto.in.HashtagIdRequestDto;
import com.multitap.member.entity.Hashtag;
import com.multitap.member.infrastructure.HashtagRepository;
import com.multitap.member.kafka.producer.HashtagDto;
import com.multitap.member.kafka.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HashtagServiceImpl implements HashtagService {

    private final HashtagRepository hashtagRepository;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void addOrUpdateHashtags(List<HashtagIdRequestDto> hashtagIdRequestDtoList, String uuid) {

        boolean existingHashtag = hashtagRepository.existsByUuid(uuid);

        if (existingHashtag) {
            hashtagRepository.deleteByUuid(uuid);
        }

        List<Hashtag> hashtag = hashtagRepository.saveAll(hashtagIdRequestDtoList.stream()
                .map(HashtagIdRequestDto::toEntity)
                .collect(Collectors.toList()));

        kafkaProducerService.sendCreateHashTag(HashtagDto.from(hashtag));

    }

}

