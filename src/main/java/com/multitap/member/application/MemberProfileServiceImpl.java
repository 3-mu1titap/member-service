package com.multitap.member.application;

import com.multitap.member.common.exception.BaseException;
import com.multitap.member.common.response.BaseResponseStatus;
import com.multitap.member.dto.in.MenteeProfileRequestDto;
import com.multitap.member.dto.in.MentorProfileRequestDto;
import com.multitap.member.entity.MenteeProfile;
import com.multitap.member.entity.MentorProfile;
import com.multitap.member.infrastructure.MenteeProfileRepository;
import com.multitap.member.infrastructure.MentorProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberProfileServiceImpl implements MemberProfileService {

    private final MentorProfileRepository mentorProfileRepository;
    private final MenteeProfileRepository menteeProfileRepository;

    @Override
    public void addMentorProfile(MentorProfileRequestDto mentorProfileRequestDto) {

        if (mentorProfileRepository.existsByUuid(mentorProfileRequestDto.getUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PROFILE);
        }
        mentorProfileRepository.save(mentorProfileRequestDto.toEntity(mentorProfileRequestDto));
    }

    @Override
    public void changeMentorProfile(MentorProfileRequestDto mentorProfileRequestDto) {
        MentorProfile mentorProfile = mentorProfileRepository.findByUuid(mentorProfileRequestDto.getUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PROFILE));

        mentorProfileRepository.save(mentorProfileRequestDto.updateToEntity(mentorProfileRequestDto, mentorProfile));
    }

    @Override
    public void addMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto) {

        if (menteeProfileRepository.existsByUuid(menteeProfileRequestDto.getUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PROFILE);
        }

        menteeProfileRepository.save(menteeProfileRequestDto.toEntity(menteeProfileRequestDto));
    }

    @Override
    public void changeMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto) {
        MenteeProfile menteeProfile = menteeProfileRepository.findByUuid(menteeProfileRequestDto.getUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PROFILE));

        menteeProfileRepository.save(menteeProfileRequestDto.updateToEntity(menteeProfileRequestDto, menteeProfile));
    }

}
