package com.example.data.datasource

import com.example.data.entity.model.dto.Venues
import io.reactivex.Completable
import io.reactivex.Flowable

interface VenueDataSource {
    fun exploreVenues(isRefresh: Boolean, coordinate: String): Completable
    fun loadLocations(): Flowable<Venues>
}
