package com.multitap.member.presentation;

import com.multitap.member.application.ReactionService;
import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.dto.in.ReactionRequestDto;
import com.multitap.member.vo.in.ReactionRequestVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "마이페이지 관리 API", description = "마이페이지 관련 API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final ReactionService reactionService;

    @Operation(summary = "특정 회원에 대한 반응(좋아요/블랙리스트) 등록", description = "특정 회원에 대한 반응(좋아요 또는 싫어요)을 등록합니다.")
    @PostMapping("/{targetUuid}/reaction")
    public BaseResponse<Void> addReaction(@RequestBody ReactionRequestVo reactionRequestVo, @PathVariable("targetUuid") String targetUuid, @RequestHeader("Uuid") String uuid) {
        reactionService.toggleReaction(ReactionRequestDto.from(reactionRequestVo, targetUuid, uuid));
        return new BaseResponse<>();
    }
}


