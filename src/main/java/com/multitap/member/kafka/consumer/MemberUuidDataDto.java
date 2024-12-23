package com.multitap.member.kafka.consumer;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MemberUuidDataDto {
    List<String> menteeUuid;
    List<String> mentorUuid;
}
