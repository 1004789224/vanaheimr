package io.vanaheimr.system.module;


import io.swagger.v3.oas.annotations.media.Schema;

public record UserDto(
        @Schema(description = "用户编号", example = "1024") Long id,
        @Schema(description = "用户名", example = "nanfeng") String username,
        String nickname,
        String avatar,
        String mobile,
        String email,
        String status,
        String remark,
        String createTime,
        String updateTime
) {

}