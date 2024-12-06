package com.multitap.member.application;

import com.multitap.member.common.exception.BaseException;
import com.multitap.member.common.exception.CustomBaseException;
import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.common.response.BaseResponseStatus;
import com.multitap.member.entity.MemberPointAmount;
import com.multitap.member.infrastructure.MemberPointRepository;
import com.multitap.member.dto.in.UserReqDto;
import java.util.Optional;
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
        log.info("userReqDto: at serviceImpl {}" , userReqDto.toString());

        Optional<MemberPointAmount> resMemberPointAmount = memberPointRepository.findByUserUuid(userReqDto.getUserUuid());

        if(resMemberPointAmount.isEmpty()){
            memberPointRepository.save(userReqDto.toEntity());
        }
        else {
            memberPointRepository.save(userReqDto.toAddPointEntity(resMemberPointAmount.get()));
        }

    }


    @Override
    public MemberPointAmount saveMemberPoint(UserReqDto userReqDto){
        return memberPointRepository.save(userReqDto.toEntity());
    }

    @Override
    public Boolean useMemberPoint(String userUuid, Integer pointAmount){
        log.info("userUuid: {}, pointAmount: {}", userUuid, pointAmount);
        MemberPointAmount memberPointAmount = memberPointRepository.findByUserUuid(userUuid).orElseThrow(
            () -> new BaseException(BaseResponseStatus.NO_EXIST_USER)
        );

        if(memberPointAmount.getAmount() <= pointAmount){   // 같은 금액일 때도 고려
            throw new BaseException(BaseResponseStatus.NOT_ENOUGH_POINT);   
        }

        log.info("after if statements");

        memberPointRepository.save(MemberPointAmount.builder()
            .id(memberPointAmount.getId())
            .userUuid(memberPointAmount.getUserUuid())
            .amount(memberPointAmount.getAmount() - pointAmount)
            .build());


        return true;
    }

    @Override
    public Integer getMemberPoint(String userUuid){
        log.info("userUuid: {} in serviceImpl", userUuid);
        MemberPointAmount memberPointAmount = memberPointRepository.findByUserUuid(userUuid).orElseThrow(
            () -> new BaseException(BaseResponseStatus.NO_EXIST_USER)
        );

        return memberPointAmount.getAmount();
    }

}
