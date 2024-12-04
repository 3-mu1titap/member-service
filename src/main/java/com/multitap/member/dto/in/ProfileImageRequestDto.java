package com.multitap.member.dto.in;

import com.multitap.member.entity.MemberProfileImage;
import com.multitap.member.vo.in.ProfileImageRequestVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageRequestDto {

    private String uuid;
    private String profileImageUrl;

    @Builder
    public ProfileImageRequestDto(String uuid, String profileImageUrl) {
        this.uuid = uuid;
        this.profileImageUrl = profileImageUrl;
    }

    public static ProfileImageRequestDto from(ProfileImageRequestVo profileImageRequestVo, String uuid) {
        return ProfileImageRequestDto.builder()
                .uuid(uuid)
                .profileImageUrl(profileImageRequestVo.getProfileImageUrl())
                .build();
    }

    public MemberProfileImage toEntity(ProfileImageRequestDto profileImageRequestDto) {
        return MemberProfileImage.builder()
                .uuid(profileImageRequestDto.getUuid())
                .profileImageUrl(profileImageRequestDto.getProfileImageUrl())
                .build();
    }


    public MemberProfileImage updateToEntity(ProfileImageRequestDto profileImageRequestDto, MemberProfileImage memberProfileImage) {
        return MemberProfileImage.builder()
                .id(memberProfileImage.getId())
                .uuid(profileImageRequestDto.getUuid())
                .profileImageUrl(profileImageRequestDto.getProfileImageUrl())
                .build();
    }
}
