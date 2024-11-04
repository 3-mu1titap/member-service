package com.multitap.member.application;

import com.multitap.member.dto.in.HashtagIdRequestDto;

import java.util.List;

public interface HashtagService {
    void addOrUpdateHashtags(List<HashtagIdRequestDto> hashtagIdRequestDtoList, String uuid);
}
