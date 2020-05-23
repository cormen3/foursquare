package com.example.data.datasource

import com.example.common_test.TestUtil
import com.example.data.dto.VenuesResponseDto
import com.example.data.network.VenueDataService
import io.reactivex.Single

class FailedVenueApi : VenueDataService {
    override fun exploreVenues(queries: Map<String, String>, radius: Long): Single<VenuesResponseDto> {
        throw TestUtil.error()
    }
}