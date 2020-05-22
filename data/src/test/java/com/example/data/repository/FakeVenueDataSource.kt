package com.example.data.repository

import com.example.common_test.TestUtil
import com.example.data.datasource.VenueDataSource
import com.example.data.entity.model.dto.Venues
import io.reactivex.Flowable
import io.reactivex.Single

class FakeVenueDataSource : VenueDataSource {
    override fun exploreVenues(isRefresh: Boolean): Single<Boolean> =
        Single.just(true)

    override fun loadLocations(): Flowable<Venues> =
        Flowable.just(TestUtil.fakeVenues())
}