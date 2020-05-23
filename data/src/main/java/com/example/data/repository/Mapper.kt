package com.example.data.repository

import com.example.data.entity.model.dto.Venues
import com.example.data.entity.model.local.VenueEntity
import com.example.data.entity.model.remote.Category
import com.example.data.entity.model.remote.Icon
import com.example.data.entity.model.remote.Price
import com.example.data.entity.model.remote.VenueInfo
import com.example.domain.entity.venue.*

fun Venues.toVenuesObject() = VenuesObject(
    totalCount, Venues.map { it.toVenueObject() }.toMutableList()
)

fun VenueEntity.toVenueObject() = VenueObject(
    venueId, name, location
)

fun VenueInfo.toVenueInfoObject() = VenueInfoObject(
    id,
    name,
    location,
    categories?.map { it.toCategoryObject() },
    rating,
    ratingColor,
    price?.toPriceObject()
)

fun Category.toCategoryObject() = CategoryObject(
    id,
    name,
    pluralName,
    shortName,
    icon?.toIconObject(),
    primary
)

fun Icon.toIconObject() = IconObject(
    prefix,
    suffix
)

fun Price.toPriceObject() = PriceObject(
    tier,
    message,
    currency
)
