package io.vanaheimr.account.service

import io.vanaheimr.account.repository.RoleRepository
import io.vanaheimr.system.module.vo.RoleVo
import jakarta.inject.Singleton

@Singleton
class RoleService(private val roleRepository: RoleRepository) {
    suspend fun save(roleVo: RoleVo): RoleVo {
        return roleRepository.save(roleVo)
    }
}