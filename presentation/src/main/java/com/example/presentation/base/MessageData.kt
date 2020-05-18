package com.example.presentation.base

import androidx.annotation.StringRes

class MessageData(
    var message: String? = null,
    @StringRes
    var resource: Int? = null
)
