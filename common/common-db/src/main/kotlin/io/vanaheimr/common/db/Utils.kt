package io.vanaheimr.common.db

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.jooq.*


class ConditionSelection {

    var origin: Condition? = null

    fun and(other: Condition) {
        origin = if (origin != null) {
            origin!!.and(other)
        } else {
            other
        }
    }

    fun andIf(valid: Boolean, condition: Condition) {
        if (valid) {
            and(condition)
        }
    }

    fun andIf(valid: Boolean, condition: () -> Condition) {
        if (valid) {
            and(condition())
        }
    }

    fun andIfNotNull(valid: Any?, condition: Condition) {
        if (valid != null) {
            and(condition)
        }
    }

    fun andIfNotNull(valid: Any?, condition: () -> Condition) {
        if (valid != null) {
            and(condition())
        }
    }

    fun andIfNotNullOrEmpty(valid: String?, condition: Condition) {
        if (!valid.isNullOrBlank()) {
            and(condition)
        }
    }

    fun andIfNotNullOrEmpty(valid: List<*>?, condition: Condition) {
        if (!valid.isNullOrEmpty()) {
            and(condition)
        }
    }

    fun andIfNotNullOrEmpty(valid: String?, condition: () -> Condition) {
        if (!valid.isNullOrBlank()) {
            and(condition())
        }
    }

    fun andIfNotNullOrEmpty(valid: List<*>?, condition: () -> Condition) {
        if (!valid.isNullOrEmpty()) {
            and(condition())
        }
    }

}

/**
 * =============================== SELECT ===================================
 */
fun <R : Record> SelectWhereStep<R>.where(selection: ConditionSelection.() -> Unit): SelectConditionStep<R> {
    val conditionSelection = ConditionSelection()
    conditionSelection.selection()
    if (conditionSelection.origin != null) {
        return where(conditionSelection.origin)
    }
    return where()
}


/**
 * =============================== UPDATE ===================================
 */

fun <T, R : Record> UpdateSetStep<R>.set(field: Field<T>, value: Any): UpdateSetMoreStep<R> {
    return set(field, field.dataType.convert(value))
}

fun <T, R : Record> UpdateSetStep<R>.setIf(valid: Boolean, field: Field<T>, value: Any): UpdateSetMoreStep<R> {
    if (valid) {
        return set(field, value)
    }
    return this as UpdateSetMoreStep<R>
}

fun <T, R : Record> UpdateSetStep<R>.setIfNotNull(field: Field<T>, value: Any?): UpdateSetMoreStep<R> {
    if (value != null) {
        return set(field, value)
    }
    return this as UpdateSetMoreStep<R>
}

fun <R : Record> UpdateWhereStep<R>.where(selection: ConditionSelection.() -> Unit): UpdateConditionStep<R> {
    val conditionSelection = ConditionSelection()
    conditionSelection.selection()
    if (conditionSelection.origin != null) {
        return this.where(conditionSelection.origin)
    }
    return where()
}


/**
 * =============================== DELETE ===================================
 */

fun <R : Record> DeleteWhereStep<R>.where(selection: ConditionSelection.() -> Unit): DeleteConditionStep<R> {
    val conditionSelection = ConditionSelection()
    conditionSelection.selection()
    if (conditionSelection.origin != null) {
        return this.where(conditionSelection.origin)
    }
    return where()
}

// todo 可以在这里注入事物上下文

suspend fun RowCountQuery.awaitOne(): Int {
    return this.awaitFirstOrNull() ?: 0
}

suspend fun <R : Record> ResultQuery<R>.awaitOne(): R? {
    return this.awaitFirstOrNull()
}


suspend fun <R : Record> ResultQuery<R>.awaitList(): List<R> {
    return this.asFlow().toList()
}
