package com.example.domain.entity.venue

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("cc") val cc: String?,
    @SerializedName("country") val country: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("labeledLatLngs") val labeledLatLngs: List<LabeledLatLngsItem>?,
    @SerializedName("lng") val lng: Double?,
    @SerializedName("distance") val distance: Int?,
    @SerializedName("formattedAddress") val formattedAddress: List<String>?,
    @SerializedName("city") val city: String?,
    @SerializedName("postalCode") val postalCode: String?,
    @SerializedName("state") val state: String?,
    @SerializedName("crossStreet") val crossStreet: String?,
    @SerializedName("lat") val lat: Double?
)