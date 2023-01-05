package io.vanaheimr.account.repository

import io.micronaut.data.repository.jpa.kotlin.CoroutineJpaSpecificationExecutor
import io.micronaut.data.repository.kotlin.CoroutinePageableCrudRepository
import io.vanaheimr.account.po.Role

interface RoleRepository : CoroutinePageableCrudRepository<Role, Long>, CoroutineJpaSpecificationExecutor<Role> {


    suspend fun findAll() {

    }
}