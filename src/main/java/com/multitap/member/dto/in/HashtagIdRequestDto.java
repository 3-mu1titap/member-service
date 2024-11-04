package com.multitap.member.dto.in;

import com.multitap.member.entity.Hashtag;
import com.multitap.member.vo.in.HashtagIdRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class HashtagIdRequestDto {

    private Long hashtagId;
    private String uuid;

    @Builder
    public HashtagIdRequestDto(Long hashtagId, String uuid) {
        this.hashtagId = hashtagId;
        this.uuid = uuid;
    }

    public static List<HashtagIdRequestDto> from(List<HashtagIdRequestVo> hashtagIdRequestVoList, String uuid) {
        return hashtagIdRequestVoList.stream()
                .map(hashtagIdRequestVo -> HashtagIdRequestDto.builder()
                        .hashtagId(hashtagIdRequestVo.getHashtagId())
                        .uuid(uuid)
                        .build())
                .collect(Collectors.toList());
    }

    public static Hashtag toEntity(HashtagIdRequestDto hashtagIdRequestDto) {
        return Hashtag.builder()
                .uuid(hashtagIdRequestDto.getUuid())
                .hashtagId(hashtagIdRequestDto.getHashtagId())
                .build();
    }

}
