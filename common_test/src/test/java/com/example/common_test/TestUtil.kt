package com.example.common_test

import com.example.common.error.ErrorCode
import com.example.common.error.ErrorThrowable
import com.example.data.datasource.toVenueEntity
import com.example.data.entity.model.dto.Venues
import com.example.data.entity.model.local.VenueEntity
import com.example.data.entity.model.remote.VenuesResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object TestUtil {

    private val gson = Gson()

    private fun parseJson(fileName: String): String =
        javaClass.classLoader?.getResourceAsStream("json/$fileName")
            ?.bufferedReader().use { it!!.readText() }

    fun error(): ErrorThrowable = ErrorThrowable(ErrorCode.ERROR_HAPPENED)

    fun fakeVenues(): Venues? {
        return Venues(0, venuesResponse()?.response?.groups?.get(0)?.items
            ?.map { venueItem ->
                venueItem.toVenueEntity()
            } as MutableList<VenueEntity>)
    }

    fun venuesResponse(): VenuesResponse? {
        val listType = object : TypeToken<VenuesResponse>() {}.type
        return gson.fromJson(parseJson("venues.json"), listType) as VenuesResponse
    }
}