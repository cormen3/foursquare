package com.example.presentation.base

import androidx.annotation.StringRes

interface MessagePresenter {
    fun showMessage(message: MessageData)
    fun showMessage(message: String)
    fun showMessage(@StringRes resourceId: Int)
}