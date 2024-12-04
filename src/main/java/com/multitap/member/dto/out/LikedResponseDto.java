package com.multitap.member.dto.out;

import com.multitap.member.entity.Reaction;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikedResponseDto {

    private boolean liked;

    @Builder
    public LikedResponseDto(boolean liked) {
        this.liked = liked;
    }

    public static LikedResponseDto from(boolean liked){
        return LikedResponseDto.builder()
                .liked(liked)
                .build();
    }
}
