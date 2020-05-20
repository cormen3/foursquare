package com.example.data.repository

import com.example.data.entity.model.dto.Venues
import com.example.data.entity.model.local.VenueEntity
import com.example.domain.entity.venue.VenueObject
import com.example.domain.entity.venue.VenuesObject

fun Venues.toVenuesObject() = VenuesObject(
    totalCount, Venues.map { it.toVenueObject() }.toMutableList()
)

fun VenueEntity.toVenueObject() = VenueObject(
    name, location
)

fun VenueEntity.map() = VenueObject(
    name, location
)


