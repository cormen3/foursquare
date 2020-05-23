package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName

class VenuesResponse(
    @SerializedName("response") val response: VenueData
)