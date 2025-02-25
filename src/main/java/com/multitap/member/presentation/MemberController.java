package com.multitap.member.presentation;

import com.multitap.member.application.HashtagService;
import com.multitap.member.application.MemberProfileService;
import com.multitap.member.application.ReactionService;
import com.multitap.member.common.response.BaseResponse;
import com.multitap.member.dto.in.*;
import com.multitap.member.dto.out.TargetUuidResponseDto;
import com.multitap.member.entity.MemberProfileImage;
import com.multitap.member.kafka.producer.KafkaProducerService;
import com.multitap.member.kafka.producer.ProfileImageDto;
import com.multitap.member.vo.in.*;
import com.multitap.member.vo.out.TargetUuidResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "마이페이지 관리 API", description = "마이페이지 관련 API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final ReactionService reactionService;
    private final HashtagService hashtagService;
    private final MemberProfileService memberProfileService;
    private final KafkaProducerService kafkaProducerService;


    @Operation(summary = "특정 회원에 대한 반응(좋아요/블랙리스트) 등록", description = "특정 회원에 대한 반응(좋아요 또는 싫어요)을 등록합니다.")
    @PostMapping("/{targetUuid}/reaction")
    public BaseResponse<Void> addReaction(@RequestBody ReactionRequestVo reactionRequestVo, @PathVariable("targetUuid") String targetUuid, @RequestHeader("userUuid") String uuid) {
        reactionService.toggleReaction(ReactionRequestDto.from(reactionRequestVo, targetUuid, uuid));
        return new BaseResponse<>();
    }

    //todo: 페이지네이션 처리하기
    @Operation(summary = "관심 멘토로 등록한 멘토 uuid 리스트 반환", description = "관심 멘토 uuid 리스트 반환")
    @GetMapping("/like/targetUuid")
    public BaseResponse<List<TargetUuidResponseVo>> getLikeTargetUuid(@RequestHeader("userUuid") String uuid) {
        List<TargetUuidResponseVo> TargetUuidResponseVoList = reactionService.getLikeTargetUuid(uuid)
                .stream()
                .map(TargetUuidResponseDto::toVo)
                .toList();
        return new BaseResponse<>(TargetUuidResponseVoList);
    }

    @Operation(summary = "블랙리스트 멘토로 등록한 멘토 uuid 리스트 반환", description = "블랙리스트 멘토 uuid 리스트 반환")
    @GetMapping("/black/targetUuid")
    public BaseResponse<List<TargetUuidResponseVo>> getBlackTargetUuid(@RequestHeader("userUuid") String uuid) {
        List<TargetUuidResponseVo> TargetUuidResponseVoList = reactionService.getBlackTargetUuid(uuid)
                .stream()
                .map(TargetUuidResponseDto::toVo)
                .toList();
        return new BaseResponse<>(TargetUuidResponseVoList);
    }

    @Operation(summary = "회원 해시태그 등록, 수정", description = "자신이 원하는 해시태그를 등록 또는 수정합니다.")
    @PostMapping("/hashtag")
    public BaseResponse<Void> addHashtag(@RequestHeader("userUuid") String uuid, @RequestBody List<HashtagIdRequestVo> hashtagIdRequestVo) {
        hashtagService.addOrUpdateHashtags(HashtagIdRequestDto.from(hashtagIdRequestVo, uuid), uuid);
        return new BaseResponse<>();
    }

    @Operation(summary = "멘토 프로필 등록", description = "멘토의 프로필을 등록합니다.")
    @PostMapping("/mentor/profile")
    public BaseResponse<Void> addMentorProfile(@RequestHeader("userUuid") String uuid, @RequestBody MentorProfileRequestVo mentorProfileRequestVo) {
        memberProfileService.addMentorProfile(MentorProfileRequestDto.from(mentorProfileRequestVo, uuid));
        return new BaseResponse<>();
    }

    @Operation(summary = "멘티 프로필 등록", description = "멘티의 프로필을 등록합니다.")
    @PostMapping("/mentee/profile")
    public BaseResponse<Void> addMenteeProfile(@RequestHeader("userUuid") String uuid, @RequestBody MenteeProfileRequestVo menteeProfileRequestVo) {
        memberProfileService.addMenteeProfile(MenteeProfileRequestDto.from(menteeProfileRequestVo, uuid));

        return new BaseResponse<>();
    }

    @Operation(summary = "멘토 프로필 수정", description = "멘토의 프로필을 수정합니다.")
    @PutMapping("/mentor/profile")
    public BaseResponse<Void> changeMentorProfile(@RequestHeader("userUuid") String uuid, @RequestBody MentorProfileRequestVo mentorProfileRequestVo) {
        memberProfileService.changeMentorProfile(MentorProfileRequestDto.from(mentorProfileRequestVo, uuid));
        return new BaseResponse<>();
    }

    @Operation(summary = "멘티 프로필 수정", description = "멘티의 프로필을 수정합니다.")
    @PutMapping("/mentee/profile")
    public BaseResponse<Void> changeMenteeProfile(@RequestHeader("userUuid") String uuid, @RequestBody MenteeProfileRequestVo menteeProfileRequestVo) {
        memberProfileService.changeMenteeProfile(MenteeProfileRequestDto.from(menteeProfileRequestVo, uuid));
        return new BaseResponse<>();
    }

    @Operation(summary = "회원 프로필 이미지 등록", description = "회원의 프로필 이미지를 등록합니다.")
    @PostMapping("/profile-image")
    public BaseResponse<Void> addProfileImage(@RequestHeader("userUuid") String uuid, @RequestBody ProfileImageRequestVo profileImageRequestVo) {
        memberProfileService.addProfileImage(ProfileImageRequestDto.from(profileImageRequestVo, uuid));
        return new BaseResponse<>();
    }

    @Operation(summary = "회원 프로필 이미지 수정", description = "회원의 프로필 이미지를 등록합니다.")
    @PutMapping("/profile-image")
    public BaseResponse<Void> changeProfileImage(@RequestHeader("userUuid") String uuid, @RequestBody ProfileImageRequestVo profileImageRequestVo) {
        memberProfileService.changeProfileImage(ProfileImageRequestDto.from(profileImageRequestVo, uuid));
        return new BaseResponse<>();
    }



}


