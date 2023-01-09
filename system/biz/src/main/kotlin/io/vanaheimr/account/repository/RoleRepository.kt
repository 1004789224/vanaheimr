package io.vanaheimr.account.repository

import io.vanaheimr.common.db.setIfNotNull
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


    suspend fun getByName(name: String): RoleVo? {
        return dslContext.select(Tables.SYSTEM_ROLE.ID, Tables.SYSTEM_ROLE.NAME, Tables.SYSTEM_ROLE.DESCRIPTION)
            .from(Tables.SYSTEM_ROLE)
            .where(Tables.SYSTEM_ROLE.NAME.eq(name).and(Tables.SYSTEM_ROLE.DELETED.eq(false)))
            .awaitFirstOrNull()
            ?.let {
                return RoleVo(
                    it.get(Tables.SYSTEM_ROLE.ID),
                    it.get(Tables.SYSTEM_ROLE.NAME),
                    it.get(Tables.SYSTEM_ROLE.DESCRIPTION),
                )
            }

    }

    suspend fun deleteById(id: Long): Boolean {
        return dslContext.update(Tables.SYSTEM_ROLE)
            .set(Tables.SYSTEM_ROLE.DELETED, true)
            .where(Tables.SYSTEM_ROLE.ID.eq(id))
            .awaitFirstOrNull()
            ?.let {
                it > 0
            } ?: false
    }

    suspend fun update(id: Long, name: String?, desc: String?): Boolean {
        return dslContext.update(Tables.SYSTEM_ROLE)
            .setIfNotNull(Tables.SYSTEM_ROLE.NAME, name)
            .setIfNotNull(Tables.SYSTEM_ROLE.DESCRIPTION, desc)
            .where(Tables.SYSTEM_ROLE.ID.eq(id))
            .awaitFirstOrNull()
            ?.let {
                it > 0
            } ?: false
    }
}