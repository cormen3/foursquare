package com.example.data.entity.model.dto

import com.example.data.entity.model.local.VenueEntity

data class Venues(
    val totalCount: Int,
    val Venues: MutableList<VenueEntity>
)