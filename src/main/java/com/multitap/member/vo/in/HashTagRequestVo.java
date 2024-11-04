package com.multitap.member.vo.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HashTagRequestVo {

    @Schema(description = "해시태그ID", example = "1", nullable = true)
    private Long id;

}
