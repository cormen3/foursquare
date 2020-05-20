package com.example.common.error

import com.google.gson.Gson
import io.reactivex.exceptions.CompositeException
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

object ErrorHandler {

    fun convert(throwable: Throwable): Throwable {
        return when (throwable) {
            is HttpException -> {
                parseError(throwable.response()?.errorBody()?.string())
            }
            is SocketTimeoutException -> {
                ErrorThrowable(ErrorCode.ERROR_TIMEOUT, ErrorMessage.ERROR_TIMEOUT_MESSAGE)
            }
            is IOException -> {
                ErrorThrowable(ErrorCode.ERROR_IO, ErrorMessage.ERROR_IO_MESSAGE)
            }
            else -> {
                ErrorThrowable(ErrorCode.ERROR_HAPPENED, ErrorMessage.ERROR_HAPPENED_MESSAGE)
            }
        }
    }

    fun getError(throwable: Throwable): String? {
        var error: String? = ErrorMessage.ERROR_HAPPENED_MESSAGE

        if (throwable is CompositeException && throwable.exceptions.size > 1) {
            throwable.exceptions.forEach { exception ->
                if (exception is ErrorThrowable && !exception.message.isNullOrEmpty())
                    error = exception.message.orEmpty()
            }
        } else if (!throwable.message.isNullOrEmpty()) {
            error = when (throwable) {
                is ErrorThrowable -> throwable.message.orEmpty()
                else -> ErrorMessage.ERROR_HAPPENED_MESSAGE
            }
        }
        return error
    }

    private fun parseError(errorBody: String?): ErrorThrowable {
        return try {
            val result = Gson().fromJson(errorBody, ErrorModel::class.java)
            ErrorThrowable(result.error.errorCode, result.error.errorMessage!!)
        } catch (e: Exception) {
            ErrorThrowable(ErrorCode.ERROR_HAPPENED, ErrorMessage.ERROR_HAPPENED_MESSAGE)
        }
    }
}