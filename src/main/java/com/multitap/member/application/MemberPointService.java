package com.multitap.member.application;

import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.vo.in.UserReqDto;

public interface MemberPointService {

    BaseResponse<?> addMemberPoint(UserReqDto userReqDto);

}
