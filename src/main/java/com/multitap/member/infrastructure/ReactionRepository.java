package com.multitap.member.infrastructure;

import com.multitap.member.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction,Long> {
    Optional<Reaction> findByUuidAndTargetUuidAndType(String uuid, String targetUuid, boolean type);
    List<Reaction> findByUuidAndTypeTrueAndLikedTrue(String uuid);
    List<Reaction> findByUuidAndTypeFalseAndLikedTrue(String uuid);
}
