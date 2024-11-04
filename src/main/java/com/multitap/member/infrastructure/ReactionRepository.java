package com.multitap.member.infrastructure;

import com.multitap.member.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction,Long> {
    Optional<Reaction> findByUuidAndTargetUuidAndType(String uuid, String targetUuid, boolean type);
}
