package io.vanaheimr.system.module.vo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * 角色视图对象
 * 实现验证和openapi
 */
@Introspected
@Serdeable
public record RoleVo(
        @Schema(description = "角色ID")
        Long id,
        @Schema(description = "角色名称")
        @NotBlank(message = "角色名称不能为空")
        String name,
        @Schema(description = "角色描述")
        String description
) {
}
