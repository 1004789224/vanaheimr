package io.vanaheimr.common.db.po

import io.vanaheimr.common.core.RequestContext
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BaseModelTest{

    @Test
    fun `test BaseModel`(){
        RequestContext.get().userId=3
        val baseModel = CustomModel("hello")
        baseModel.save()
        println(baseModel)
        assertNotNull(baseModel)
    }
}