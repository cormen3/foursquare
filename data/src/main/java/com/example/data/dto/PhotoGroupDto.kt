package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class PhotoGroupDto(
    @SerializedName("count") val count: Int?,
    @SerializedName("items") val items: List<PhotoDto>?
)