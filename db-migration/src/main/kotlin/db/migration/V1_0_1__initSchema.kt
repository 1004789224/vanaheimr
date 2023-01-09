@file:Suppress("unused", "ClassName")

package db.migration

import io.vanaheimr.common.db.JooqMigration
import org.jooq.DSLContext
import org.jooq.impl.DSL

class V1_0_1__initSchema : JooqMigration() {
    override fun DSLContext.migrate() {
        createTable("system_account")
            .column("id", org.jooq.impl.SQLDataType.BIGINT.identity(true))
            .column("name", org.jooq.impl.SQLDataType.VARCHAR(255).notNull())
            .column("create_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("create_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("update_time", org.jooq.impl.SQLDataType.TIMESTAMP)
            .column("update_by", org.jooq.impl.SQLDataType.BIGINT)
            .column("version", org.jooq.impl.SQLDataType.BIGINT.defaultValue(0))
            .column("deleted", org.jooq.impl.SQLDataType.BOOLEAN.defaultValue(false).notNull())
            .column("tenant_id", org.jooq.impl.SQLDataType.BIGINT.notNull())
            .column("email", org.jooq.impl.SQLDataType.VARCHAR(255))
            .column("password", org.jooq.impl.SQLDataType.VARCHAR(255).notNull())
            .column("phone", org.jooq.impl.SQLDataType.VARCHAR(255).notNull())
            .column("status", org.jooq.impl.SQLDataType.TINYINT)
            .column("avatar", org.jooq.impl.SQLDataType.VARCHAR(255))
            .constraints(
                DSL.constraint("pk_account").primaryKey("id"),
                DSL.constraint("uk_account_email").unique("email"),
                DSL.constraint("uk_account_phone").unique("phone")
            )
            .execute()
        // add comment
        commentOnTable("system_account").`is`("系统账号").execute()
        commentOnColumn(DSL.name("system_account", "id")).`is`("主键").execute()
        commentOnColumn(DSL.name("system_account", "name")).`is`("姓名").execute()
        commentOnColumn(DSL.name("system_account", "create_time")).`is`("创建时间").execute()
        commentOnColumn(DSL.name("system_account", "create_by")).`is`("创建人").execute()
        commentOnColumn(DSL.name("system_account", "update_time")).`is`("更新时间").execute()
        commentOnColumn(DSL.name("system_account", "update_by")).`is`("更新人").execute()
        commentOnColumn(DSL.name("system_account", "version")).`is`("版本").execute()
        commentOnColumn(DSL.name("system_account", "deleted")).`is`("是否删除").execute()
        commentOnColumn(DSL.name("system_account", "tenant_id")).`is`("租户ID").execute()
        commentOnColumn(DSL.name("system_account", "email")).`is`("邮箱").execute()
        commentOnColumn(DSL.name("system_account", "password")).`is`("密码").execute()
        commentOnColumn(DSL.name("system_account", "phone")).`is`("手机号").execute()
        commentOnColumn(DSL.name("system_account", "status")).`is`("状态").execute()
        commentOnColumn(DSL.name("system_account", "avatar")).`is`("头像").execute()
        // add index
        createIndex("idx_account_name").on("system_account", "name").execute()
        createIndex("idx_account_email").on("system_account", "email").execute()
        createIndex("idx_account_phone").on("system_account", "phone").execute()
        createIndex("idx_account_tenant_id").on("system_account", "tenant_id").execute()

        // system_role
        createTable("system_role")
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
                DSL.constraint("pk_role").primaryKey("id"),
            )
            .execute()

        createIndex("idx_role_tenant_id").on("system_role", "tenant_id").execute()
        // add comment
        commentOnTable("system_role").`is`("系统角色").execute()
        commentOnColumn(DSL.name("system_role", "id")).`is`("主键").execute()
        commentOnColumn(DSL.name("system_role", "name")).`is`("角色名称").execute()
        commentOnColumn(DSL.name("system_role", "create_time")).`is`("创建时间").execute()
        commentOnColumn(DSL.name("system_role", "create_by")).`is`("创建人").execute()
        commentOnColumn(DSL.name("system_role", "update_time")).`is`("更新时间").execute()
        commentOnColumn(DSL.name("system_role", "update_by")).`is`("更新人").execute()
        commentOnColumn(DSL.name("system_role", "version")).`is`("版本").execute()
        commentOnColumn(DSL.name("system_role", "deleted")).`is`("是否删除").execute()
        commentOnColumn(DSL.name("system_role", "tenant_id")).`is`("租户ID").execute()
        commentOnColumn(DSL.name("system_role", "description")).`is`("描述").execute()

        // system_permission
        createTable("system_permission")
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
            )
            .execute()
        // add index
        createIndex("idx_permission_tenant_id").on("system_permission", "tenant_id").execute()
        createIndex("idx_permission_parent_id").on("system_permission", "parent_id").execute()
        createIndex("idx_permission_path").on("system_permission", "path").execute()
        // add comment
        commentOnTable("system_permission").`is`("系统权限").execute()
        commentOnColumn(DSL.name("system_permission", "id")).`is`("主键").execute()
        commentOnColumn(DSL.name("system_permission", "name")).`is`("权限名称").execute()
        commentOnColumn(DSL.name("system_permission", "create_time")).`is`("创建时间").execute()
        commentOnColumn(DSL.name("system_permission", "create_by")).`is`("创建人").execute()
        commentOnColumn(DSL.name("system_permission", "update_time")).`is`("更新时间").execute()
        commentOnColumn(DSL.name("system_permission", "update_by")).`is`("更新人").execute()
        commentOnColumn(DSL.name("system_permission", "version")).`is`("版本").execute()
        commentOnColumn(DSL.name("system_permission", "deleted")).`is`("是否删除").execute()
        commentOnColumn(DSL.name("system_permission", "tenant_id")).`is`("租户ID").execute()
        commentOnColumn(DSL.name("system_permission", "description")).`is`("描述").execute()
        commentOnColumn(DSL.name("system_permission", "parent_id")).`is`("父级ID").execute()
        commentOnColumn(DSL.name("system_permission", "path")).`is`("路径").execute()
        commentOnColumn(DSL.name("system_permission", "sort")).`is`("排序").execute()
        commentOnColumn(DSL.name("system_permission", "metadata")).`is`("元数据").execute()


        // system_role_permission
        createTable("system_role_permission")
            .column("id", org.jooq.impl.SQLDataType.BIGINT.identity(true))
            .column("role_id", org.jooq.impl.SQLDataType.BIGINT)
            .column("permission_id", org.jooq.impl.SQLDataType.BIGINT)
            .constraints(
                org.jooq.impl.DSL.constraint("pk_role_permission").primaryKey("id"),
                org.jooq.impl.DSL.constraint("uk_role_permission").unique("role_id", "permission_id")
            )
            .execute()


        // system_organization
        createTable("system_organization")
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
            )
            .execute()
        // add index
        createIndex("idx_organization_tenant_id").on("system_organization", "tenant_id").execute()
        createIndex("idx_organization_parent_id").on("system_organization", "parent_id").execute()
        createIndex("idx_organization_path").on("system_organization", "path").execute()
        // add comment
        commentOnTable("system_organization").`is`("系统组织").execute()
        commentOnColumn(DSL.name("system_organization", "id")).`is`("主键").execute()
        commentOnColumn(DSL.name("system_organization", "name")).`is`("组织名称").execute()
        commentOnColumn(DSL.name("system_organization", "create_time")).`is`("创建时间").execute()
        commentOnColumn(DSL.name("system_organization", "create_by")).`is`("创建人").execute()
        commentOnColumn(DSL.name("system_organization", "update_time")).`is`("更新时间").execute()
        commentOnColumn(DSL.name("system_organization", "update_by")).`is`("更新人").execute()
        commentOnColumn(DSL.name("system_organization", "version")).`is`("版本").execute()
        commentOnColumn(DSL.name("system_organization", "deleted")).`is`("是否删除").execute()
        commentOnColumn(DSL.name("system_organization", "tenant_id")).`is`("租户ID").execute()
        commentOnColumn(DSL.name("system_organization", "description")).`is`("描述").execute()
        commentOnColumn(DSL.name("system_organization", "parent_id")).`is`("父级ID").execute()
        commentOnColumn(DSL.name("system_organization", "path")).`is`("路径").execute()
        commentOnColumn(DSL.name("system_organization", "sort")).`is`("排序").execute()
        commentOnColumn(DSL.name("system_organization", "metadata")).`is`("元数据").execute()
    }
}