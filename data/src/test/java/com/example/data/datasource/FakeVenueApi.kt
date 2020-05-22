package com.example.data.datasource

import com.example.common_test.TestUtil
import com.example.data.entity.model.remote.VenuesResponse
import com.example.data.network.VenueDataService
import io.reactivex.Single

class FakeVenueApi : VenueDataService {
    override fun exploreVenues(queries: Map<String, String>, radius: Long): Single<VenuesResponse> {
        return Single.just(TestUtil.venuesResponse())
    }
}