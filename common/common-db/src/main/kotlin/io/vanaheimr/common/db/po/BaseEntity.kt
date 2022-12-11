package io.vanaheimr.common.db.po

import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLDeleteAll
import org.hibernate.annotations.Where
import java.time.LocalDateTime
import javax.persistence.*
import kotlin.properties.Delegates

/**
 * base-entity
 * 统一包含id、创建时间、更新时间、创建人、更新人、租户id、版本号、是否删除
 */

import javax.persistence.*

@MappedSuperclass
@Where(clause = "deleted = 0")
@SQLDelete(sql = "update base_entity set deleted = 1 where id = ?")
abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    lateinit var createdAt: LocalDateTime

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    lateinit var updatedAt: LocalDateTime

    @Column(name = "created_by")
    lateinit var createdBy: String

    @Column(name = "updated_by")
    lateinit var updatedBy: String

    @Column(name = "tenant_id")
     var tenantId: Long? = null

    @Version
    var version: Int =0

    @Column(name = "deleted")
    var deleted: Boolean = false

    @PrePersist
    fun prePersist() {
        createdAt = LocalDateTime.now()
        updatedAt = createdAt
    }

    @PreUpdate
    fun preUpdate() {
        updatedAt = LocalDateTime.now()
    }
}