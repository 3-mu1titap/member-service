package com.multitap.member.vo.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReactionRequestVo {

    @Schema(description = "유형", example = "true", nullable = true)
    private boolean type;

//    @Schema(description = "좋아요 유무", example = "true", nullable = true)
//    private boolean liked;

}

