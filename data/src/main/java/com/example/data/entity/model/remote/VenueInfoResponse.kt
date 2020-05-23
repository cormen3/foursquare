package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName

class VenueInfoResponse(
    @SerializedName("venue") val venue: VenueInfo?
)