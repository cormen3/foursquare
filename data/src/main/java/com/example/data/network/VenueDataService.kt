package com.example.data.network

import com.example.data.BuildConfig
import com.example.data.entity.model.remote.VenueDetailsResponse
import com.example.data.entity.model.remote.VenuesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface VenueDataService {

    @GET(value = "${BuildConfig.API_VERSION}/venues/explore")
    fun exploreVenues(
        @QueryMap queries: Map<String, String>,
        @Query("radius") radius: Long = 1000
    ): Single<VenuesResponse>

    @GET(value = "${BuildConfig.API_VERSION}/venues/{id}")
    fun getVenueDetails(@Path("id") venueId: String): Single<VenueDetailsResponse>
}