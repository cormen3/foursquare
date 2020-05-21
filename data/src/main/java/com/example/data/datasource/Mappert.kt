package com.example.data.datasource

import android.location.Location
import com.example.data.entity.model.local.VenueEntity
import com.example.domain.entity.venue.VenueItem

fun VenueItem.toVenueEntity() = VenueEntity(
    0,
    this.venue.name,
    this.venue.location
)

fun Location?.toCoordinates(): String =
    this?.latitude.toString().plus(",").plus(this?.longitude.toString())