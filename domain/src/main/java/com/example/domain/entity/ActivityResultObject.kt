package com.example.domain.entity

import android.content.Intent

class ActivityResultObject(
    val requestCode: Int,
    val resultCode: Int,
    val data: Intent?
)