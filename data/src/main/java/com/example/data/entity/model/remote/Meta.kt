package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName

class Meta(
    @SerializedName("code") val code: Int,
    @SerializedName("requestId") val requestId: String
)