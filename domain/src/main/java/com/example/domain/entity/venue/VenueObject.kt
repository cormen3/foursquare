package com.example.domain.entity.venue

import com.example.domain.entity.DomainObject

data class VenueObject(
    var name: String = "",
    val location: Location
) : DomainObject