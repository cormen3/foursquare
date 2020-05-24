package com.example.common_test

import com.example.common.error.ErrorCode
import com.example.common.error.ErrorThrowable
import com.example.data.datasource.toVenueEntity
import com.example.data.dto.VenueDetailsDto
import com.example.data.dto.VenuesDto
import com.example.data.dto.VenuesResponseDto
import com.example.data.repository.toVenueInfoObject
import com.example.domain.entity.venue.VenueInfoObject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object TestUtil {

    private val gson = Gson()

    private fun parseJson(fileName: String): String =
        javaClass.classLoader?.getResourceAsStream("json/$fileName")
            ?.bufferedReader().use { it!!.readText() }

    fun error(): ErrorThrowable = ErrorThrowable(ErrorCode.ERROR_HAPPENED)

    fun fakeVenues(): VenuesDto? {
        val items =
            venuesResponse()?.response?.groups?.get(0)?.items?.map { venueItem ->
                venueItem.toVenueEntity()
            }?.toMutableList()
        return VenuesDto(0, items!!)
    }

    fun venuesResponse(): VenuesResponseDto? {
        val listType = object : TypeToken<VenuesResponseDto>() {}.type
        return gson.fromJson(parseJson("venues.json"), listType) as VenuesResponseDto
    }

    fun venueDetailsResponse(): VenueDetailsDto? {
        val listType = object : TypeToken<VenueDetailsDto>() {}.type
        return gson.fromJson(parseJson("venue_details.json"), listType) as VenueDetailsDto
    }

    fun fakeVenueInfoObject(): VenueInfoObject =
        venueDetailsResponse()?.response?.venueDto?.toVenueInfoObject()!!
}