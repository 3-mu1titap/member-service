package com.multitap.member.application;

import com.multitap.member.common.exception.BaseException;
import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.common.response.BaseResponseStatus;
import com.multitap.member.entity.MemberPointAmount;
import com.multitap.member.infrastructure.MemberPointRepository;
import com.multitap.member.dto.in.UserReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberPointServiceImpl implements MemberPointService{

    private final MemberPointRepository memberPointRepository;

    @Transactional
    @Override
    public void addMemberPoint(UserReqDto userReqDto)  {
        log.info("userReqDto: {}" , userReqDto.toString());

        MemberPointAmount resMemberPointAmount = memberPointRepository.findByUserUuid(userReqDto.getUserUuid()).orElseThrow(
            () -> new BaseException(BaseResponseStatus.DISABLED_USER)
        );

        memberPointRepository.save(userReqDto.toAddPointEntity(resMemberPointAmount));
    }


    @Override
    public MemberPointAmount saveMemberPoint(UserReqDto userReqDto){
        return memberPointRepository.save(userReqDto.toEntity());
    }

}
