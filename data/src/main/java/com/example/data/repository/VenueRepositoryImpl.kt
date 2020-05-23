package com.example.data.repository

import com.example.data.datasource.VenueDataSource
import com.example.domain.entity.venue.VenueInfoObject
import com.example.domain.entity.venue.VenuesObject
import com.example.domain.repository.VenueRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class VenueRepositoryImpl @Inject constructor(
    private val dataSource: VenueDataSource
) : VenueRepository {

    override fun exploreVenues(isLoadMore: Boolean): Single<Boolean> =
        dataSource.exploreVenues(isLoadMore)

    override fun loadLocations(): Flowable<VenuesObject> =
        dataSource.loadLocations().map { it.toVenuesObject() }

    override fun getVenueDetails(venueId: String): Single<VenueInfoObject> =
        dataSource.getVenueDetails(venueId).map { it.response?.venueDto?.toVenueInfoObject() }
}