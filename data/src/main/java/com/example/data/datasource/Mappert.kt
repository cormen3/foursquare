package com.example.data.datasource

import android.location.Location
import com.example.data.local.VenueEntity
import com.example.data.dto.VenueItemDto

fun VenueItemDto.toVenueEntity() = VenueEntity(
    0,
    this.venueDto?.id,
    this.venueDto?.name,
    this.venueDto?.location
)

fun Location?.toCoordinates(): String =
    this?.latitude.toString().plus(",").plus(this?.longitude.toString())