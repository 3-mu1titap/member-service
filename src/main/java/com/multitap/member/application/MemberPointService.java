package com.multitap.member.application;

import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.dto.in.UserReqDto;
import com.multitap.member.entity.MemberPointAmount;

public interface MemberPointService {

    BaseResponse<Void> addMemberPoint(UserReqDto userReqDto);
    BaseResponse<MemberPointAmount> saveMemberPoint(UserReqDto userReqDto);
}
