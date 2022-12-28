package io.vanaheimr.system.api;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.vanaheimr.system.module.OrgDto;
import org.springframework.http.ResponseEntity;

@Tag(name = "org", description = "组织管理api")
public interface OrgApi {


    // 包含以下接口
    // 创建组织，修改组织，删除组织，查询组织，查询组织列表，查询组织列表（分页）


    @ApiResponses(
            value = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(
                            responseCode = "200",
                            description = "创建组织成功",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = OrgDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "创建组织失败"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "无权限"
                    )
            }
    )
    @SecurityRequirements(
            @SecurityRequirement(name = "bearerAuth", scopes = {"system:org:create"})
    )
    ResponseEntity<OrgDto> createOrg(OrgDto orgDto);
}
