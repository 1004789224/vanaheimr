package io.vanaheimr.common.db

import io.ebean.typequery.TQRootBean


fun<T,R> TQRootBean<T, R>.and(f:R.()->R): TQRootBean<T, R> {
    and()
        .f()
    endAnd()
    return this
}

fun<T,R> TQRootBean<T, R>.andIf(condition: Boolean,f:R.()->R): TQRootBean<T, R> {
    if (condition) {
        and()
            .f()
        endAnd()
    }
    return this
}