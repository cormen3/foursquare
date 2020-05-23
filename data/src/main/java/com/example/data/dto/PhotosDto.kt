package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class PhotosDto(
    @SerializedName("count") val count: Int?,
    @SerializedName("groups") val groups: List<PhotoGroupDto>?
)