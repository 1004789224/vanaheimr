package io.vanaheimr.system.module;

import io.swagger.v3.oas.annotations.media.Schema;

public record OrgDto(
        @Schema(description = "组织编号", example = "1")
        Long id,
        @Schema(description = "组织名称", example = "腾讯")
        String name,

        @Schema(description = "父组织编号", example = "1")
        Long parentId,
        @Schema(description = "描述", example = "腾讯")
        String description) {
}
