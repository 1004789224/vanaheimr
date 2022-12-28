package io.vanaheimr.account.po

import io.ebean.annotation.EnumValue

enum class AccountStatus {
    @EnumValue("1")
    ENABLED,
    @EnumValue("0")
    DISABLED,
}