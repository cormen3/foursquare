package com.example.data.dto

import com.google.gson.annotations.SerializedName

class VenueDetailsDto(
    @SerializedName("metaData") val metaDtoData: MetaDto?,
    @SerializedName("response") val response: VenueInfoResponse?
)
