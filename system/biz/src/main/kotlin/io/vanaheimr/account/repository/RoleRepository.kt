package io.vanaheimr.account.repository

import io.vanaheimr.system.module.vo.RoleVo
import io.vanaheimr.system.po.Tables
import jakarta.inject.Singleton
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.jooq.DSLContext
import java.time.LocalDateTime

@Singleton
class RoleRepository(private val dslContext: DSLContext) {
    suspend fun save(roleVo: RoleVo): RoleVo {
        return dslContext.insertInto(Tables.SYSTEM_ROLE)
            .set(Tables.SYSTEM_ROLE.NAME, roleVo.name)
            .set(Tables.SYSTEM_ROLE.DESCRIPTION, roleVo.description)
            .set(Tables.SYSTEM_ROLE.CREATE_BY, 1L)
            .set(Tables.SYSTEM_ROLE.CREATE_TIME, LocalDateTime.now())
            .set(Tables.SYSTEM_ROLE.UPDATE_BY, 1L)
            .set(Tables.SYSTEM_ROLE.UPDATE_TIME, LocalDateTime.now())
            .set(Tables.SYSTEM_ROLE.DELETED, false)
            .set(Tables.SYSTEM_ROLE.VERSION, 0L)
            .set(Tables.SYSTEM_ROLE.TENANT_ID, 1L)
            .returning()
            .awaitFirstOrNull()
            ?.map {
                RoleVo(
                    it.get(Tables.SYSTEM_ROLE.ID),
                    it.get(Tables.SYSTEM_ROLE.NAME),
                    it.get(Tables.SYSTEM_ROLE.DESCRIPTION),
                )
            } ?: error("cant find")
    }
}