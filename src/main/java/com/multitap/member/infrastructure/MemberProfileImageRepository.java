package com.multitap.member.infrastructure;

import com.multitap.member.entity.MemberProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberProfileImageRepository extends JpaRepository<MemberProfileImage, Long> {
    Optional<MemberProfileImage> findByUuid(String uuid);
}
