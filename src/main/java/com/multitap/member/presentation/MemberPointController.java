package com.multitap.member.presentation;

import com.multitap.member.application.MemberPointService;
import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.dto.in.UserReqDto;
import com.multitap.member.entity.MemberPointAmount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
@Tag(name = "유저 포인트 관련 API", description = "유저 포인트 관련 API endpoints")
public class MemberPointController {

    private final MemberPointService memberPointService;

    @Operation(summary = "회원 포인트 내역을 생성", description ="회원 포인트 내역을 생성합니다" )
    @PostMapping("/points/create")
    public BaseResponse<MemberPointAmount> createPoints(@RequestBody UserReqDto userReqDto)  {
        log.info("userReqDto {}", userReqDto.toString());
        return new BaseResponse<>(memberPointService.saveMemberPoint(userReqDto));
    }


    @Operation(summary = "회원 포인트 증가", description ="회원 포인트를 증가시킵니다.")
    @PutMapping("/points/add")
    public BaseResponse<Void> addPoints(@RequestBody UserReqDto userReqDto)  {
        log.info("userReqDto {}", userReqDto.toString());
        memberPointService.addMemberPoint(userReqDto);

        return new BaseResponse<>();
    }


    @Operation(summary = "회원 포인트 사용")
    @PutMapping("/points/use")
    public BaseResponse<Boolean> usePoints(@RequestParam("userUuid") String userUuid,@RequestParam("pointPrice") Integer pointPrice){
        log.info("userUuid: {}, pointPrice: {} in controller", userUuid, pointPrice);

        return new BaseResponse<>(memberPointService.useMemberPoint(userUuid,pointPrice));
    }






}
