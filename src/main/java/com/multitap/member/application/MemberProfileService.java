package com.multitap.member.application;

import com.multitap.member.dto.in.MenteeProfileRequestDto;
import com.multitap.member.dto.in.MentorProfileRequestDto;
import com.multitap.member.dto.in.ProfileImageRequestDto;

public interface MemberProfileService {
    void addMentorProfile(MentorProfileRequestDto mentorProfileRequestDto);
    void changeMentorProfile(MentorProfileRequestDto mentorProfileRequestDto);
    void addMenteeProfile(MenteeProfileRequestDto from);
    void changeMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto);
    void addProfileImage(ProfileImageRequestDto profileImageRequestDto);
    void changeProfileImage(ProfileImageRequestDto profileImageRequestDto);
}
