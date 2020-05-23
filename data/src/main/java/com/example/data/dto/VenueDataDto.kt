package com.example.data.dto

import com.google.gson.annotations.SerializedName

data class VenueDataDto(
    @SerializedName("totalResults") val totalResults: Int?,
    @SerializedName("suggestedRadius") val suggestedRadius: Int?,
    @SerializedName("headerFullLocation") val headerFullLocation: String?,
    @SerializedName("headerLocationGranularity") val headerLocationGranularity: String?,
    @SerializedName("groups") val groups: List<GroupDto>?,
    @SerializedName("suggestedBoundsObject") val suggestedBoundsDtoObject: SuggestedBoundsDto?,
    @SerializedName("headerLocation") val headerLocation: String?
)