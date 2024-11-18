package com.multitap.member.application;

import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.common.response.BaseResponseStatus;
import com.multitap.member.entity.MemberPointAmount;
import com.multitap.member.infrastructure.MemberPointRepository;
import com.multitap.member.vo.in.UserReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberPointServiceImpl implements MemberPointService{

    private final MemberPointRepository memberPointRepository;

    @Override
    public BaseResponse<Void> addMemberPoint(UserReqDto userReqDto){

        // 존재하지 않는다면
        if(memberPointRepository.findByUuid(userReqDto.getUserUuid()).isEmpty()){
            return new BaseResponse<>(BaseResponseStatus.NO_EXIST_USER);
        }
        // 존재한다면
        MemberPointAmount memberPointAmount = memberPointRepository.findByUuid(userReqDto.getUserUuid()).get();


        // update
        try {
            memberPointAmount.addAmount(userReqDto.getPointQuantity());
            memberPointRepository.save(memberPointAmount);
        }
        catch (Exception e){    // update 실패 시
            return new BaseResponse<>(BaseResponseStatus.POINT_UPDATE_FAILED);
        }
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);

    }

}
