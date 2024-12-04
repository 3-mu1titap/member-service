package com.multitap.member.common.exception;

import com.multitap.member.common.response.BaseResponseStatus;
import lombok.Getter;

// global Exception handler에 잡히지 않고 오류 발생을 위해
@Getter
public class CustomBaseException extends RuntimeException {
    private final BaseResponseStatus status;

    public CustomBaseException(BaseResponseStatus status) {
        this.status = status;

    }
}
