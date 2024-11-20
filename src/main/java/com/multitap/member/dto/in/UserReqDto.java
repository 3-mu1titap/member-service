package com.multitap.member.dto.in;

import com.multitap.member.entity.MemberPointAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class UserReqDto {

    private String userUuid;
    private Integer pointQuantity;


    public MemberPointAmount toEntity(){
        return MemberPointAmount.builder()
               .userUuid(userUuid)
               .amount(pointQuantity)
               .build();
    }

    public MemberPointAmount toAddPointEntity(MemberPointAmount memberPointAmount){
        return MemberPointAmount.builder()
            .id(memberPointAmount.getId())
            .userUuid(memberPointAmount.getUserUuid())
            .amount(memberPointAmount.getAmount() + pointQuantity)
            .build();
    }
}
