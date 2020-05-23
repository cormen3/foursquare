package com.example.domain.entity.venue

data class Location(
    val cc: String?,
    val country: String?,
    val address: String?,
    val labeledLatLngs: List<LabeledLatLngsItem>?,
    val lng: Double?,
    val distance: Int?,
    val formattedAddress: List<String>?,
    val city: String?,
    val postalCode: String?,
    val state: String?,
    val crossStreet: String?,
    val lat: Double?
)