package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName


data class VenueItem(
    @SerializedName("venue") val venue: Venue?,
    @SerializedName("reasonsObject") val reasonsObject: Reasons?
)
