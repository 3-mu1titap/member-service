package com.multitap.member.kafka.producer;

import com.multitap.member.entity.Hashtag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class HashtagDto {

    private String uuid;
    private Long hashtagId;

    @Builder
    public HashtagDto(String uuid, Long hashtagId) {
        this.uuid = uuid;
        this.hashtagId = hashtagId;
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



