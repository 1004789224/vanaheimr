package io.vanaheimr.common.db.po


import io.ebean.Model
import io.ebean.annotation.*
import java.time.LocalDateTime
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version
import kotlin.properties.Delegates

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
@MappedSuperclass
open class BaseModel : Model() {

    @Id
    var id: Long = 0

    @Version
    var version: Long = 0

    @WhenCreated
    lateinit var createAt: LocalDateTime

    @WhenModified
    lateinit var updateAt: LocalDateTime

    @WhoCreated
    var createBy :Long=0
    @WhenModified
    var updateBy :Long=0

    @TenantId
    var tenantId :Long=0

    @SoftDelete
    var isDeleted: Boolean = false

    @Length(300)
    var remark: String? = null
}