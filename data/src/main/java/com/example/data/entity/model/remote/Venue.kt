package com.example.data.entity.model.remote

import com.example.domain.entity.venue.Location

open class Venue(
    open val id: String?,
    open var name: String?,
    open val location: Location?
)
