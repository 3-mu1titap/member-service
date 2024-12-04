package com.multitap.member.kafka.producer;

import com.multitap.member.entity.MemberProfileImage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageDto {

    private String uuid;
    private String profileImageUrl;

    @Builder
    public ProfileImageDto(String uuid, String profileImageUrl) {
        this.uuid = uuid;
        this.profileImageUrl = profileImageUrl;
    }

    public static ProfileImageDto from(MemberProfileImage memberProfileImage) {
        return ProfileImageDto.builder()
                .uuid(memberProfileImage.getUuid())
                .profileImageUrl(memberProfileImage.getProfileImageUrl())
                .build();
    }

}
