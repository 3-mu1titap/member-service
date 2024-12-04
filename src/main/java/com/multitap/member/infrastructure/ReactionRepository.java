package com.multitap.member.infrastructure;

import com.multitap.member.entity.Reaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction,Long> {
    Optional<Reaction> findByUuidAndTargetUuidAndType(String uuid, String targetUuid, boolean type);

    @Query("SELECT r FROM Reaction r WHERE r.targetUuid = ?1 AND r.type = true AND r.liked = true ORDER BY r.createdDate DESC")
    List<Reaction> findByTargetUuidAndTypeTrueAndLikedTrue(String targetUuid, Pageable pageable);

    @Query("SELECT r FROM Reaction r WHERE r.targetUuid < ?1 AND r.type = true AND r.liked = true ORDER BY r.createdDate DESC")
    List<Reaction> findPreviousByTargetUuidAndTypeTrueAndLikedTrue(String cursorTargetUuid, Pageable pageable);

    List<Reaction> findByUuidAndTypeFalseAndLikedTrue(String uuid);
}
