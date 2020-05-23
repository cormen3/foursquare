package com.example.domain.entity.venue

import com.google.gson.annotations.SerializedName

data class LabeledLatLngsItem(
    @SerializedName("lng") val lng: Double?,
    @SerializedName("label") val label: String?,
    @SerializedName("lat") val lat: Double?
)