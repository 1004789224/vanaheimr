package io.vanaheimr.common.db.po


import io.vanaheimr.common.db.TenantId
import io.vanaheimr.common.db.WhoCreated
import io.vanaheimr.common.db.WhoModified
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Version
import java.time.LocalDateTime

/**
 * ebean BaseTable
 * @author vanaheimr
 * 所有表的基类
 * @property id 主键
 * @property createAt 创建时间
 * @property updateAt 更新时间
 * @property createBy 创建人
 * @property updateBy 更新人
 * @property isDeleted 是否删除
 * @property version 版本号
 * @property remark 备注
 * @property tenantId 租户id
 */
@Where("is_deleted = 0")
@MappedSuperclass
open class BaseEntity {

    @Id
    @GeneratedValue
    var id: Long = 0

    @Version
    var version: Long = 0

    @CreatedAt
    lateinit var createAt: LocalDateTime

    @DateUpdated
    lateinit var updateAt: LocalDateTime

    @WhoCreated
    var createBy: Long = 0

    @WhoModified
    var updateBy: Long = 0

    @TenantId
    var tenantId: Long = 0

    var isDeleted: Boolean = false


    var remark: String? = null
}