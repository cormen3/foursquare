package com.example.data.dto

import com.example.data.local.VenueEntity

data class VenuesDto(
    val totalCount: Int,
    val Venues: MutableList<VenueEntity>
)