package com.multitap.member.entity;

import com.multitap.member.common.exception.BaseException;
import com.multitap.member.common.response.BaseResponseStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberPointAmount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userUuid;
    @Column(nullable = true)
    @ColumnDefault("0")
    private Integer amount;


    public void addAmount(Integer amount){
        if(amount == 0)
            throw new BaseException(BaseResponseStatus.WRONG_POINT_ACCESS);
        else    // 음수값 올 시 감소
            this.amount += amount;
    }

}
