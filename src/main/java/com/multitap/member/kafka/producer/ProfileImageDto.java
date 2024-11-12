package com.multitap.member.kafka.producer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageDto {

    private String profileImageUrl;
    private Boolean thumbChecked;
    private String mediaType;
    private String mediaKind;
    private Integer mediaSeq;

    @Builder
    public ProfileImageDto(String profileImageUrl, Boolean thumbChecked, String mediaType, String mediaKind, Integer mediaSeq) {
        this.profileImageUrl = profileImageUrl;
        this.thumbChecked = thumbChecked;
        this.mediaType = mediaType;
        this.mediaKind = mediaKind;
        this.mediaSeq = mediaSeq;
    }

}
