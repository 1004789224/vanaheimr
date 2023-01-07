package io.vanaheimr.system.module.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.vanaheimr.common.core.Page;
import io.vanaheimr.common.core.Pageable;
import io.vanaheimr.system.module.vo.RoleVo;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;


// https://akobor.me/posts/wiring-up-micronaut-jooq-flyway-and-testcontainers-with-r2dbc
@Tag(name = "角色管理")
public interface RoleApi {

    @Nullable
    @Operation(
            summary = "根据ID查询角色",
            description = "根据ID查询角色",
            operationId = "getRoleById"

    )
    RoleVo getRoleById(Long id);

    RoleVo save(RoleVo roleVo);

    void delete(@Nonnull long id);

    RoleVo update(RoleVo roleVo);

    Page<RoleVo> page(Pageable pageable, @Nullable String name);
}
