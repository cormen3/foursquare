package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName

class VenueDetailsResponse(
    @SerializedName("metaData") val metaData: Meta?,
    @SerializedName("response") val response: VenueInfoResponse?
)
