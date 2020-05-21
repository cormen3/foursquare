package com.example.domain.repository

import com.example.domain.entity.venue.VenuesObject
import io.reactivex.Completable
import io.reactivex.Flowable

interface VenueRepository {
    fun exploreVenues(isRefresh: Boolean): Completable
    fun loadLocations(): Flowable<VenuesObject>
}