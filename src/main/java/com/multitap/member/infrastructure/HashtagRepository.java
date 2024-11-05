package com.multitap.member.infrastructure;

import com.multitap.member.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    boolean existsByUuid(String uuid);
    void deleteByUuid(String uuid);
}

