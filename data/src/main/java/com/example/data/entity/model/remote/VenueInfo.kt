package com.example.data.entity.model.remote

import com.example.domain.entity.venue.Location

class VenueInfo (
    val id: String?,
    var name: String?,
    val location: Location?,
    val categories: List<Category>?,
    val rating : Float?,
    val ratingColor: String?,
    val price: Price?
)