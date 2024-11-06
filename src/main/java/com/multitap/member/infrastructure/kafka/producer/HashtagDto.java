package com.multitap.member.infrastructure.kafka.producer;

import com.multitap.member.entity.Hashtag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class HashtagDto {

    private Long hashtagId;
    private String uuid;

    @Builder
    public HashtagDto(Long hashtagId, String uuid) {
        this.hashtagId = hashtagId;
        this.uuid = uuid;
    }

    public static List<HashtagDto> from(List<Hashtag> hashtag) {
        return hashtag.stream()
                .map(hashtags -> HashtagDto.builder()
                        .hashtagId(hashtags.getHashtagId())
                        .uuid(hashtags.getUuid())
                        .build())
                .collect(Collectors.toList());
    }
}



