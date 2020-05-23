package com.example.data.dto

import com.google.gson.annotations.SerializedName

class VenueInfoResponse(
    @SerializedName("venue") val venueDto: VenueInfoDto?
)