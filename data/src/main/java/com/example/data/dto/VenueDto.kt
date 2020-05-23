package com.example.data.dto

import com.example.domain.entity.venue.Location
import com.google.gson.annotations.SerializedName

open class VenueDto(
    @SerializedName("id") val id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("location") val location: Location?
)
