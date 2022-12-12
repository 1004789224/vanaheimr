package io.vanaheimr.account.po

import io.ebean.annotation.EnumValue

enum class OrgStatus {
    @EnumValue("1")
    ENABLED,
    @EnumValue("0")
    DISABLED,
}
