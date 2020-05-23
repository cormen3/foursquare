package com.example.data.entity.model.remote

data class VenueData(
    val totalResults: Int?,
    val suggestedRadius: Int?,
    val headerFullLocation: String?,
    val headerLocationGranularity: String?,
    val groups: List<Group>?,
    val suggestedBoundsObject: SuggestedBounds?,
    val headerLocation: String?
)