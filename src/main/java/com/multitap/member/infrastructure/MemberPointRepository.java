package com.multitap.member.infrastructure;

import com.multitap.member.entity.MemberPointAmount;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPointRepository extends JpaRepository<MemberPointAmount, Long> {

    Optional<MemberPointAmount> findByUuid(String uuid);



}
