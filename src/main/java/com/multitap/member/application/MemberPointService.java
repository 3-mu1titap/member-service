package com.multitap.member.application;

import com.multitap.member.dto.in.UserReqDto;
import com.multitap.member.entity.MemberPointAmount;

public interface MemberPointService {

    void addMemberPoint(UserReqDto userReqDto);
    MemberPointAmount saveMemberPoint(UserReqDto userReqDto);

}
