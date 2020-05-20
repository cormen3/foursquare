package com.example.common.extensions

fun Int?.orZero(): Int = this ?: 0
fun Int?.orNegative(): Int = this ?: -1
