package io.vanaheimr.account.controller

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.vanaheimr.account.service.RoleService
import io.vanaheimr.common.core.Page
import io.vanaheimr.common.core.Pageable
import io.vanaheimr.system.module.api.RoleApi
import io.vanaheimr.system.module.vo.RoleVo
import kotlinx.coroutines.runBlocking

@Controller("/system")
class RoleController(private val roleService: RoleService) : RoleApi {
    override fun getRoleById(id: Long): RoleVo? {
        return null
    }

    @Post("/role")
    @ExecuteOn(value = TaskExecutors.IO)
    override fun save(@Body roleVo: RoleVo): RoleVo {
        return runBlocking { roleService.save(roleVo) }
    }

    override fun delete(id: Long) {}
    override fun update(roleVo: RoleVo): RoleVo {
        return null ?: error("cant find")
    }

    override fun page(pageable: Pageable, name: String): Page<RoleVo> {
        return null ?: error("cant find")
    }
}