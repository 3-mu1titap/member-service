package com.multitap.member.application;

import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.dto.in.UserReqDto;

public interface MemberPointService {

    BaseResponse<?> addMemberPoint(UserReqDto userReqDto);
    BaseResponse<?> saveMemberPoint(UserReqDto userReqDto);
}
