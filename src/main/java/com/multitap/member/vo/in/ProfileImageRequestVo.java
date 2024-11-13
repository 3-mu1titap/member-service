package com.multitap.member.vo.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageRequestVo {

    @Schema(description = "프로필 이미지 URL", example = "https://cdn.imweb.me/upload/S20190918d038d5b2c1898/ec9d644636a5a.jpeg", nullable = true)
    private String profileImageUrl;

    @Schema(description = "썸네일 미디어", example = "true", nullable = true)
    private Boolean thumbChecked;

    @Schema(description = "미디어 타입", example = "IMAGE", nullable = true)
    private String mediaType;

    @Schema(description = "미디어 종류", example = "PROFILE", nullable = true)
    private String mediaKind;

    @Schema(description = "미디어 순서", example = "1", nullable = true)
    private Integer mediaSeq;
}
