package com.multitap.member.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
public class UserReqDto {

    private String userUuid;
    private Integer pointQuantity;
}
