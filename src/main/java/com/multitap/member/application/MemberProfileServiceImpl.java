package com.multitap.member.application;

import com.multitap.member.common.exception.BaseException;
import com.multitap.member.common.response.BaseResponseStatus;
import com.multitap.member.dto.in.IntroductionTextRequestDto;
import com.multitap.member.dto.in.MenteeProfileRequestDto;
import com.multitap.member.dto.in.MentorProfileRequestDto;
import com.multitap.member.dto.in.ProfileImageRequestDto;
import com.multitap.member.dto.out.IntroductionTextResponseDto;
import com.multitap.member.entity.IntroductionText;
import com.multitap.member.entity.MemberProfileImage;
import com.multitap.member.entity.MenteeProfile;
import com.multitap.member.entity.MentorProfile;
import com.multitap.member.infrastructure.IntroductionTextRepository;
import com.multitap.member.infrastructure.MemberProfileImageRepository;
import com.multitap.member.infrastructure.MenteeProfileRepository;
import com.multitap.member.infrastructure.MentorProfileRepository;
import com.multitap.member.kafka.producer.KafkaProducerService;
import com.multitap.member.kafka.producer.MenteeProfileDto;
import com.multitap.member.kafka.producer.MentorProfileDto;
import com.multitap.member.kafka.producer.ProfileImageDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberProfileServiceImpl implements MemberProfileService {

    private final MentorProfileRepository mentorProfileRepository;
    private final MenteeProfileRepository menteeProfileRepository;
    private final MemberProfileImageRepository memberProfileImageRepository;
    private final IntroductionTextRepository introductionTextRepository;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public void addMentorProfile(MentorProfileRequestDto mentorProfileRequestDto) {
        if (mentorProfileRepository.existsByUuid(mentorProfileRequestDto.getUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PROFILE);
        }
        MentorProfile mentorProfile = mentorProfileRepository.save(mentorProfileRequestDto.toEntity(mentorProfileRequestDto));
        log.info("나이: {}", mentorProfile.getAge());
        kafkaProducerService.sendCreateMentorProfile(MentorProfileDto.from(mentorProfile));
    }

    @Override
    public void changeMentorProfile(MentorProfileRequestDto mentorProfileRequestDto) {
        MentorProfile mentorProfile = mentorProfileRepository.findByUuid(mentorProfileRequestDto.getUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PROFILE));
        mentorProfileRepository.save(mentorProfileRequestDto.updateToEntity(mentorProfileRequestDto, mentorProfile));
        log.info("나이: {}", mentorProfile.getAge());
        kafkaProducerService.sendCreateMentorProfile(MentorProfileDto.from(mentorProfile));
    }

    @Override
    public void addMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto) {
        if (menteeProfileRepository.existsByUuid(menteeProfileRequestDto.getUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PROFILE);
        }
        MenteeProfile menteeProfile = menteeProfileRepository.save(menteeProfileRequestDto.toEntity(menteeProfileRequestDto));
        log.info("나이: {}", menteeProfile.getAge());
        kafkaProducerService.sendCreateMenteeProfile(MenteeProfileDto.from(menteeProfile));
    }

    @Override
    public void changeMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto) {
        MenteeProfile menteeProfile = menteeProfileRepository.findByUuid(menteeProfileRequestDto.getUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PROFILE));
        menteeProfileRepository.save(menteeProfileRequestDto.updateToEntity(menteeProfileRequestDto, menteeProfile));
        log.info("나이: {}", menteeProfile.getAge());
        kafkaProducerService.sendCreateMenteeProfile(MenteeProfileDto.from(menteeProfile));
    }

    @Override
    public void addProfileImage(ProfileImageRequestDto profileImageRequestDto) {
        MemberProfileImage memberProfileImage = memberProfileImageRepository.save(profileImageRequestDto.toEntity(profileImageRequestDto));
        kafkaProducerService.sendCreateProfileImageUrl(ProfileImageDto.from(memberProfileImage));
    }

    @Override
    public void changeProfileImage(ProfileImageRequestDto profileImageRequestDto) {
        MemberProfileImage memberProfileImage = memberProfileImageRepository.findByUuid(profileImageRequestDto.getUuid())
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_PROFILE));
        memberProfileImageRepository.save(profileImageRequestDto.updateToEntity(profileImageRequestDto, memberProfileImage));
        kafkaProducerService.sendCreateProfileImageUrl(ProfileImageDto.from(memberProfileImage));

    }

    @Override
    public void addIntroductionText(IntroductionTextRequestDto introductionTextRequestDto) {
        if (introductionTextRepository.existsByUuid(introductionTextRequestDto.getUuid())) {
            throw new BaseException(BaseResponseStatus.DUPLICATED_PROFILE);
        }
        introductionTextRepository.save(introductionTextRequestDto.toEntity(introductionTextRequestDto));
    }

    @Override
    public IntroductionTextResponseDto getIntroductionText(String uuid) {
         IntroductionText introductionText = introductionTextRepository.findByUuid(uuid)
                 .orElseThrow(()-> new BaseException(BaseResponseStatus.NO_EXIST_PROFILE));
         return IntroductionTextResponseDto.from(introductionText);
    }


}
