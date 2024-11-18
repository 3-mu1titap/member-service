package com.multitap.member.presentation;

import com.multitap.member.application.MemberPointService;
import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.vo.in.UserReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
@Tag(name = "유저 포인트 관련 API", description = "유저 포인트 관련 API endpoints")
public class MemberPointController {

    private final MemberPointService memberPointService;

    @Operation(summary = "회원 포인트 내역을 업데이트", description ="회원 포인트 내역을 업데이트 합니다" )
    @PostMapping("/points/update")
    public BaseResponse<?> addPoints(@RequestBody UserReqDto userReqDto) {
        log.info("userReqDto {}", userReqDto.toString());
        return new BaseResponse<>(memberPointService.addMemberPoint(userReqDto));
    }
}
