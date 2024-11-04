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
public class Reaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uuid;

    @Column(nullable = false)
    private String targetUuid;

    @Column(nullable = false)
    private boolean type;

    @Column(nullable = false)
    private boolean liked;

    @Builder
    public Reaction(Long id, String uuid, String targetUuid, boolean type, boolean liked) {
        this.id = id;
        this.uuid = uuid;
        this.targetUuid = targetUuid;
        this.type = type;
        this.liked = liked;
    }

}
