package com.example.domain.entity.venue

import com.example.domain.entity.DomainObject

open class VenueObject(
    open var id: String?,
    open var name: String?,
    open val location: Location?
) : DomainObject