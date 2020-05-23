package com.example.domain.entity.venue

import com.example.domain.entity.DomainObject

open class VenueObject(
    var id: String?,
    var name: String?,
    val location: Location?
) : DomainObject