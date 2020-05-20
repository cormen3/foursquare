package com.example.common.extensions


fun String?.or(value: String) = if (this.isNullOrEmpty()) value else this

fun String?.orNA() = this.or("n/a")

fun String?.isNotNullOrEmpty() = !this.isNullOrEmpty()
