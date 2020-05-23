package com.example.data.dto

import com.google.gson.annotations.SerializedName

class VenuesResponseDto(
    @SerializedName("response") val response: VenueDataDto
)