package com.example.data.datasource

import com.example.data.entity.model.dto.Venues
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface VenueDataSource {
    fun exploreVenues(isRefresh: Boolean): Single<Boolean>
    fun loadLocations(): Flowable<Venues>
}
