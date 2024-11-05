package com.multitap.member.infrastructure;

import com.multitap.member.entity.MentorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorProfileRepository extends JpaRepository<MentorProfile,Long> {
    boolean existsByUuid(String uuid);
    Optional<MentorProfile> findByUuid(String uuid);
}
