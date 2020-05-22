package com.example.data.datasource

import com.example.data.entity.model.remote.VenuesResponse
import com.example.data.network.VenueDataService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Single

class FakeVenueApi: VenueDataService {
    private val gson = Gson()

    private fun parseJson(fileName: String): String =
        javaClass.classLoader?.getResourceAsStream("json/$fileName")
            ?.bufferedReader().use { it!!.readText() }

    override fun exploreVenues(queries: Map<String, String>, radius: Long): Single<VenuesResponse> {
        val listType = object : TypeToken<VenuesResponse>() {}.type
        val response = gson.fromJson(parseJson("venues.json"), listType) as VenuesResponse
        return Single.just(response)
    }
}