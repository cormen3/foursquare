package com.example.data.dto

import com.example.domain.entity.venue.Location
import com.google.gson.annotations.SerializedName

class VenueInfoDto (
    @SerializedName("id") val id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("location") val location: Location?,
    @SerializedName("categories") val categories: List<CategoryDto>?,
    @SerializedName("rating") val rating : Float?,
    @SerializedName("ratingColor") val ratingColor: String?,
    @SerializedName("price") val priceDto: PriceDto?,
    @SerializedName("photos") val photos: PhotosDto?
)