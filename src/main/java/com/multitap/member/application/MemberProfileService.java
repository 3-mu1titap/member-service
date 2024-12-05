package com.multitap.member.application;

import com.multitap.member.dto.in.IntroductionTextRequestDto;
import com.multitap.member.dto.in.MenteeProfileRequestDto;
import com.multitap.member.dto.in.MentorProfileRequestDto;
import com.multitap.member.dto.in.ProfileImageRequestDto;
import com.multitap.member.dto.out.IntroductionTextResponseDto;

public interface MemberProfileService {
    void addMentorProfile(MentorProfileRequestDto mentorProfileRequestDto);
    void changeMentorProfile(MentorProfileRequestDto mentorProfileRequestDto);
    void addMenteeProfile(MenteeProfileRequestDto from);
    void changeMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto);
    void addProfileImage(ProfileImageRequestDto profileImageRequestDto);
    void changeProfileImage(ProfileImageRequestDto profileImageRequestDto);
    void addIntroductionText(IntroductionTextRequestDto introductionTextRequestDto);
    IntroductionTextResponseDto getIntroductionText(String uuid);
}
