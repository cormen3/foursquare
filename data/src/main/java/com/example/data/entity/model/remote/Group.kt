package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("items") val items: List<VenueItem>?
)