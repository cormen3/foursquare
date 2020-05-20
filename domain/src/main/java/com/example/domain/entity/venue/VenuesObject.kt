package com.example.domain.entity.venue

import com.example.domain.entity.DomainObject

data class VenuesObject(
    val totalCount: Int,
    val Venues: MutableList<VenueObject>
) : DomainObject