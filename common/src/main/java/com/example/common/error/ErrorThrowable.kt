package com.example.common.error

class ErrorThrowable(val code: Int, message: String?) : Throwable(message) {
    constructor(code: Int) : this(code, null)
}