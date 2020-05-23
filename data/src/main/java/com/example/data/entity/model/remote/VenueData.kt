package com.example.data.entity.model.remote

import com.google.gson.annotations.SerializedName

data class VenueData(
    @SerializedName("totalResults") val totalResults: Int?,
    @SerializedName("suggestedRadius") val suggestedRadius: Int?,
    @SerializedName("headerFullLocation") val headerFullLocation: String?,
    @SerializedName("headerLocationGranularity") val headerLocationGranularity: String?,
    @SerializedName("groups") val groups: List<Group>?,
    @SerializedName("suggestedBoundsObject") val suggestedBoundsObject: SuggestedBounds?,
    @SerializedName("headerLocation") val headerLocation: String?
)