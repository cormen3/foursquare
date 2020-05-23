package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("prefix") val prefix: String?,
    @SerializedName("suffix") val suffix: String?,
    @SerializedName("width") val width: String?
)