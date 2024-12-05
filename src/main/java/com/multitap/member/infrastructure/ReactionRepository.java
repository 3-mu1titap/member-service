package com.multitap.member.infrastructure;

import com.multitap.member.entity.Reaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    // 최신 데이터를 가져오는 쿼리
    @Query("SELECT r FROM Reaction r WHERE r.uuid = ?1 AND r.type = true AND r.liked = true ORDER BY r.id DESC")
    List<Reaction> findByTargetUuidAndTypeTrueAndLikedTrue(String uuid, Pageable pageable);

    // PK 기준 이전 데이터를 가져오는 쿼리
    @Query("SELECT r FROM Reaction r WHERE r.uuid = ?1 AND r.id < ?2 AND r.type = true AND r.liked = true ORDER BY r.id DESC")
    List<Reaction> findPreviousByTargetUuidAndTypeTrueAndLikedTrue(String targetUuid, Long cursorId, Pageable pageable);

    // 싫어요(type=false) 최신 데이터를 가져오는 쿼리
    @Query("SELECT r FROM Reaction r WHERE r.uuid = ?1 AND r.type = false AND r.liked = true ORDER BY r.id DESC")
    List<Reaction> findByUuidAndTypeFalseAndLikedTrue(String uuid, Pageable pageable);

    // 싫어요(type=false) PK 기준 이전 데이터를 가져오는 쿼리
    @Query("SELECT r FROM Reaction r WHERE r.uuid = ?1 AND r.id < ?2 AND r.type = false AND r.liked = true ORDER BY r.id DESC")
    List<Reaction> findPreviousByUuidAndTypeFalseAndLikedTrue(String uuid, Long cursorId, Pageable pageable);

    Optional<Reaction> findByUuidAndTargetUuidAndType(String uuid, String targetUuid, boolean type);
}
