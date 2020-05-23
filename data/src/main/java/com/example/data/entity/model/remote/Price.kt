package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("tier") val tier: Int?,
    @SerializedName("message") val message: String,
    @SerializedName("currency") val currency: String
)