package com.example.data.repository

import com.example.data.dto.*
import com.example.data.local.VenueEntity
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
    priceDto?.toPriceObject(),
    photos?.toPhotosObject()
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

fun PhotosDto.toPhotosObject() = PhotosObject(
    count,
    groups?.map { it.toGroupsObject() }
)

fun PhotoGroupDto.toGroupsObject() = PhotoGroupObject(
    count,
    items?.map { it.toPhotoObject() }
)

private fun PhotoDto.toPhotoObject() = PhotoObject(
    prefix,
    suffix,
    width
)