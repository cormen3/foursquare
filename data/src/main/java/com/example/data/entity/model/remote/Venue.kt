package com.example.data.entity.model.remote

import com.example.domain.entity.venue.Location
import com.google.gson.annotations.SerializedName

open class Venue(
    @SerializedName("id") val id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("location") val location: Location?
)
