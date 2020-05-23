package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class PriceDto(
    @SerializedName("tier") val tier: Int?,
    @SerializedName("message") val message: String,
    @SerializedName("currency") val currency: String
)