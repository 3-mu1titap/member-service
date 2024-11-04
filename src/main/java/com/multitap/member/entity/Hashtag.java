package com.multitap.member.entity;

import com.multitap.member.common.response.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hashtag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long hashtagId;

    @Column(nullable = false)
    private String uuid;

    @Builder
    public Hashtag(Long id, Long hashtagId, String uuid) {
        this.id = id;
        this.hashtagId = hashtagId;
        this.uuid = uuid;

    }
}