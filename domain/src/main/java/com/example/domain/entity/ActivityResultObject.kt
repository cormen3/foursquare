package com.example.domain.entity

import android.content.Intent

data class ActivityResultObject(
    val requestCode: Int,
    val resultCode: Int,
    val data: Intent?
)