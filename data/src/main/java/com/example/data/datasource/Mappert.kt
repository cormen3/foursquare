package com.example.data.datasource

import com.example.data.entity.model.local.VenueEntity
import com.example.domain.entity.venue.VenueItem

fun VenueItem.toVenueEntity() = VenueEntity(
    0,
    this.venue.name,
    this.venue.location
)