package com.multitap.member.infrastructure;

import com.multitap.member.entity.IntroductionText;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IntroductionTextRepository extends JpaRepository<IntroductionText, Long> {
    Optional<IntroductionText> findByUuid(String uuid);
    boolean existsByUuid(String uuid);
}
