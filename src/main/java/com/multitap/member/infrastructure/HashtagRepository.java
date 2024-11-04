package com.multitap.member.infrastructure;

import com.multitap.member.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    boolean existsByUuid(String uuid);
    void deleteByUuid(String uuid);
}

