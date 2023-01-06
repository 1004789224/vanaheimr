package io.vanaheimr.common.db

import org.flywaydb.core.api.migration.BaseJavaMigration
import org.jooq.DSLContext

abstract class JooqMigration : BaseJavaMigration() {
    override fun migrate(context: org.flywaydb.core.api.migration.Context) {
        val jooq = org.jooq.impl.DSL.using(context.connection)
        migrate(jooq)
    }


    abstract fun migrate(dslContext: DSLContext)
}