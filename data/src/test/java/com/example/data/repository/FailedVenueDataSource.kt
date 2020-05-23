package com.example.data.repository

import com.example.common_test.TestUtil
import com.example.data.datasource.VenueDataSource
import com.example.data.dto.VenueDetailsDto
import com.example.data.dto.VenuesDto
import io.reactivex.Flowable
import io.reactivex.Single

class FailedVenueDataSource : VenueDataSource {
    override fun exploreVenues(isRefresh: Boolean): Single<Boolean> =
        throw TestUtil.error()

    override fun loadLocations(): Flowable<VenuesDto> =
        throw TestUtil.error()

    override fun getVenueDetails(movieId: String): Single<VenueDetailsDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}