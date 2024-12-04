package com.multitap.member;

import com.multitap.member.application.MemberPointService;
import com.multitap.member.entity.MemberPointAmount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberApplicationTests {


    @Autowired
    private MemberPointService memberPointService;

    @Test
    void contextLoads() {

        assert(
            memberPointService.useMemberPoint("test", 100).equals(true)
        );
    }

}
