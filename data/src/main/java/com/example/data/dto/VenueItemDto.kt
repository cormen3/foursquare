package com.example.data.dto

import com.google.gson.annotations.SerializedName


data class VenueItemDto(
    @SerializedName("venue") val venueDto: VenueDto?,
    @SerializedName("reasonsObject") val reasonsDtoObject: ReasonsDto?
)
