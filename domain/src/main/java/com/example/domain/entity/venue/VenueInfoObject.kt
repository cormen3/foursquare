package com.example.domain.entity.venue

class VenueInfoObject(
    var id: String?,
    var name: String?,
    val location: Location?,
    val categories: List<CategoryObject>?,
    val rating: Float?,
    val ratingColor: String?,
    val price: PriceObject?,
    val photos: PhotosObject?
)

