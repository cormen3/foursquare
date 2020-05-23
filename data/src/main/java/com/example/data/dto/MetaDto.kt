package com.example.data.dto

import com.google.gson.annotations.SerializedName

class MetaDto(
    @SerializedName("code") val code: Int,
    @SerializedName("requestId") val requestId: String
)