package com.example.data.datasource

import com.example.data.dto.VenuesDto
import com.example.data.dto.VenueDetailsDto
import io.reactivex.Flowable
import io.reactivex.Single

interface VenueDataSource {
    fun exploreVenues(isRefresh: Boolean): Single<Boolean>
    fun loadLocations(): Flowable<VenuesDto>
    fun getVenueDetails(movieId: String): Single<VenueDetailsDto>
}
