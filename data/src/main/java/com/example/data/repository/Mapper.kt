package com.example.data.repository

import com.example.data.dto.VenuesDto
import com.example.data.local.VenueEntity
import com.example.data.dto.CategoryDto
import com.example.data.dto.IconDto
import com.example.data.dto.PriceDto
import com.example.data.dto.VenueInfoDto
import com.example.domain.entity.venue.*

fun VenuesDto.toVenuesObject() = VenuesObject(
    totalCount, Venues.map { it.toVenueObject() }.toMutableList()
)

fun VenueEntity.toVenueObject() = VenueObject(
    venueId, name, location
)

fun VenueInfoDto.toVenueInfoObject() = VenueInfoObject(
    id,
    name,
    location,
    categories?.map { it.toCategoryObject() },
    rating,
    ratingColor,
    priceDto?.toPriceObject()
)

fun CategoryDto.toCategoryObject() = CategoryObject(
    id,
    name,
    pluralName,
    shortName,
    iconDto?.toIconObject(),
    primary
)

fun IconDto.toIconObject() = IconObject(
    prefix,
    suffix
)

fun PriceDto.toPriceObject() = PriceObject(
    tier,
    message,
    currency
)
