package com.example.common.extensions

infix fun <T> Boolean.then(param: T): T? = if (this) param else null

infix fun <T> Boolean.then(param: () -> T): T? = if (this) param() else null

fun Boolean?.orFalse(): Boolean = this ?: false
