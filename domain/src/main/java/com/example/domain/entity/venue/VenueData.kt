package com.example.domain.entity.venue


data class VenueData(
    val totalResults: Int = 0,
    val suggestedRadius: Int = 0,
    val headerFullLocation: String = "",
    val headerLocationGranularity: String = "",
    val groups: List<Group>,
    val suggestedBounds: SuggestedBounds,
    val headerLocation: String = ""
)