package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class GroupDto(
    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("items") val items: List<VenueItemDto>?
)