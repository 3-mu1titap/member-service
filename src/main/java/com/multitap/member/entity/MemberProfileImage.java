package com.multitap.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String profileImageUrl;

    @Builder
    public MemberProfileImage(Long id, String uuid, String profileImageUrl) {
        this.id = id;
        this.uuid = uuid;
        this.profileImageUrl = profileImageUrl;
    }

}
