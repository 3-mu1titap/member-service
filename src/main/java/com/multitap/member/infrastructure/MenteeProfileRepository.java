package com.multitap.member.infrastructure;

import com.multitap.member.entity.MenteeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenteeProfileRepository extends JpaRepository<MenteeProfile,Long> {
    boolean existsByUuid(String uuid);
    Optional<MenteeProfile> findByUuid(String uuid);
}
