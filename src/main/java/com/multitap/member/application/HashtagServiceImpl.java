package com.multitap.member.application;

import com.multitap.member.dto.in.HashtagIdRequestDto;
import com.multitap.member.entity.Hashtag;
import com.multitap.member.infrastructure.HashtagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HashtagServiceImpl implements HashtagService {

    private final HashtagRepository hashtagRepository;

    @Override
    public void addOrUpdateHashtags(List<HashtagIdRequestDto> hashtagIdRequestDtoList, String uuid) {

        boolean existingHashtag = hashtagRepository.existsByUuid(uuid);

        if (existingHashtag) {
            hashtagRepository.deleteByUuid(uuid);
        }

        // 새로운 해시태그 등록
        List<Hashtag> hashtags = hashtagIdRequestDtoList.stream()
                .map(HashtagIdRequestDto::toEntity)
                .collect(Collectors.toList());

        hashtagRepository.saveAll(hashtags);
    }

}

