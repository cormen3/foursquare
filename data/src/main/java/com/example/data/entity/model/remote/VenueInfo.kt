package com.example.data.entity.model.remote

import com.example.domain.entity.venue.Location
import com.google.gson.annotations.SerializedName

class VenueInfo (
    @SerializedName("id") val id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("location") val location: Location?,
    @SerializedName("categories") val categories: List<Category>?,
    @SerializedName("rating") val rating : Float?,
    @SerializedName("ratingColor") val ratingColor: String?,
    @SerializedName("price") val price: Price?
)