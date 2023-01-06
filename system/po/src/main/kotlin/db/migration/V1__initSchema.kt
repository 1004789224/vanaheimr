@file:Suppress("unused", "ClassName")

package db.migration

import io.vanaheimr.common.db.JooqMigration
import org.jooq.DSLContext

class V1_0_1__initSchema : JooqMigration() {
    override fun migrate(dslContext: DSLContext) {
        dslContext.createTable("system_account")
            .column("id", org.jooq.impl.SQLDataType.BIGINT.identity(true))
            .column("name", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("create_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("create_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("update_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("update_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("version", org.jooq.impl.SQLDataType.BIGINT)
            .column("deleted", org.jooq.impl.SQLDataType.BOOLEAN)
            .column("tenant_id", org.jooq.impl.SQLDataType.BIGINT)
            .column("email", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("password", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("phone", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("status", org.jooq.impl.SQLDataType.TINYINT)
            .column("avatar", org.jooq.impl.SQLDataType.VARCHAR(255))
            .constraints(
                org.jooq.impl.DSL.constraint("pk_account").primaryKey("id"),
                org.jooq.impl.DSL.constraint("uk_account_email").unique("email"),
                org.jooq.impl.DSL.constraint("uk_account_phone").unique("phone")
            )
            .execute()
        // add index
        dslContext.createIndex("idx_account_name").on("system_account").include("name").execute()
        dslContext.createIndex("idx_account_email").on("system_account").include("email").execute()
        dslContext.createIndex("idx_account_phone").on("system_account").include("phone").execute()

        // system_role
        dslContext.createTable("system_role")
            .column("id", org.jooq.impl.SQLDataType.BIGINT.identity(true))
            .column("name", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("create_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("create_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("update_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("update_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("version", org.jooq.impl.SQLDataType.BIGINT)
            .column("deleted", org.jooq.impl.SQLDataType.BOOLEAN)
            .column("tenant_id", org.jooq.impl.SQLDataType.BIGINT)
            .column("description", org.jooq.impl.SQLDataType.VARCHAR(255))
            .constraints(
                org.jooq.impl.DSL.constraint("pk_role").primaryKey("id"),
                org.jooq.impl.DSL.constraint("uk_role_name").unique("name")
            )
            .execute()

        // system_permission
        dslContext.createTable("system_permission")
            .column("id", org.jooq.impl.SQLDataType.BIGINT.identity(true))
            .column("name", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("create_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("create_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("update_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("update_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("version", org.jooq.impl.SQLDataType.BIGINT)
            .column("deleted", org.jooq.impl.SQLDataType.BOOLEAN)
            .column("tenant_id", org.jooq.impl.SQLDataType.BIGINT)
            .column("description", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("parent_id", org.jooq.impl.SQLDataType.BIGINT)
            .column("path", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("sort", org.jooq.impl.SQLDataType.INTEGER)
            .column("metadata", org.jooq.impl.SQLDataType.JSON)
            .constraints(
                org.jooq.impl.DSL.constraint("pk_permission").primaryKey("id"),
                org.jooq.impl.DSL.constraint("uk_permission_name").unique("name")
            )
            .execute()


        // system_role_permission
        dslContext.createTable("system_role_permission")
            .column("id", org.jooq.impl.SQLDataType.BIGINT.identity(true))
            .column("role_id", org.jooq.impl.SQLDataType.BIGINT)
            .column("permission_id", org.jooq.impl.SQLDataType.BIGINT)
            .constraints(
                org.jooq.impl.DSL.constraint("pk_role_permission").primaryKey("id"),
                org.jooq.impl.DSL.constraint("uk_role_permission").unique("role_id", "permission_id")
            )
            .execute()


        // system_organization
        dslContext.createTable("system_organization")
            .column("id", org.jooq.impl.SQLDataType.BIGINT.identity(true))
            .column("name", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("create_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("create_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("update_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("update_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("version", org.jooq.impl.SQLDataType.BIGINT)
            .column("deleted", org.jooq.impl.SQLDataType.BOOLEAN)
            .column("tenant_id", org.jooq.impl.SQLDataType.BIGINT)
            .column("description", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("parent_id", org.jooq.impl.SQLDataType.BIGINT)
            .column("path", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("sort", org.jooq.impl.SQLDataType.INTEGER)
            .column("metadata", org.jooq.impl.SQLDataType.JSON)
            .constraints(
                org.jooq.impl.DSL.constraint("pk_organization").primaryKey("id"),
                org.jooq.impl.DSL.constraint("uk_organization_name").unique("name")
            )
            .execute()

    }
}