package com.example.data.repository

import com.example.data.datasource.VenueDataSource
import com.example.domain.entity.venue.VenuesObject
import com.example.domain.repository.VenueRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class VenueRepositoryImpl @Inject constructor(
    private val dataSource: VenueDataSource
) : VenueRepository {

    override fun exploreVenues(isRefresh: Boolean, coordinate: String): Completable =
        dataSource.exploreVenues(isRefresh, coordinate)

    override fun loadLocations(): Flowable<VenuesObject> =
        dataSource.loadLocations().map { it.toVenuesObject() }
}
