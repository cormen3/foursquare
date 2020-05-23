package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName

data class Icon(
    @SerializedName("prefix") val prefix: String?,
    @SerializedName("suffix") val suffix: String?
)