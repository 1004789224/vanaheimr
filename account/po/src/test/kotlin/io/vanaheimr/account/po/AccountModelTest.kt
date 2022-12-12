package io.vanaheimr.account.po

import io.vanaheimr.account.po.query.QAccount
import io.vanaheimr.common.core.RequestContext
import io.vanaheimr.common.db.and
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AccountModelTest {
    @Test
    fun `test AccountModel`() {
        RequestContext.get().userId = 3
        val account = Account("hello", "world","1234564215")
        account.save()
        QAccount().name.eq("hello").findList().forEach {
            println(it)
        }

        println(QAccount()
            .and {
                name.eq("hello")
                password.eq("world")
            }.findOne()
        )

        QAccount()
            .forUpdate()

        val accountModel1 = QAccount().name.eq("hello").findOne()
        assertNotNull(accountModel1)
        assertEquals("hello", accountModel1?.name)
        assertEquals("world", accountModel1?.password)
    }
}
