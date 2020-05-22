package com.example.common_test

import com.example.common.error.ErrorCode
import com.example.common.error.ErrorThrowable
import com.google.gson.Gson

object TestUtil {

    private val gson = Gson()

    private fun parseJson(fileName: String): String =
        javaClass.classLoader?.getResourceAsStream("json/$fileName")
            ?.bufferedReader().use { it!!.readText() }

    fun error(): ErrorThrowable = ErrorThrowable(ErrorCode.ERROR_HAPPENED)
}