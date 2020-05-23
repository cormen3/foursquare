package com.example.domain.entity.venue

class VenueInfoObject(
    override var id: String?,
    override var name: String?,
    override val location: Location?,
    val categories: List<CategoryObject>?,
    val rating: Float?,
    val ratingColor: String?,
    val price: PriceObject?
) : VenueObject(id, name, location)

