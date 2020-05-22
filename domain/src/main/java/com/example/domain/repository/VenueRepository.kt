package com.example.domain.repository

import com.example.domain.entity.venue.VenuesObject
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface VenueRepository {
    fun exploreVenues(isRefresh: Boolean): Single<Boolean>
    fun loadLocations(): Flowable<VenuesObject>
}