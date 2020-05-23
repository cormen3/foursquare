package com.example.data.datasource

import com.example.common.extensions.orZero
import com.example.common.preferences.PreferencesHelper
import com.example.data.local.VenuesDao
import com.example.data.dto.VenuesDto
import com.example.data.dto.VenueDetailsDto
import com.example.data.extension.onError
import com.example.data.network.VenueDataService
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class VenueDataSourceImpl @Inject constructor(
    private val api: VenueDataService,
    private val venuesDao: VenuesDao,
    private val preferencesHelper: PreferencesHelper
) : VenueDataSource {

    @Volatile
    private var page: Int = 1

    private var totalCount: Int = 0

    override fun exploreVenues(isRefresh: Boolean): Single<Boolean> {
        return getAndInsert(isRefresh)
    }

    private fun getAndInsert(isRefresh: Boolean): Single<Boolean> {
        return api.exploreVenues(getQueryParams())
            .doOnSubscribe {
                if (isRefresh)
                    venuesDao.clearAll()
            }
            .map {
                totalCount = it.response.totalResults.orZero()
                val venueList = it.response.groups?.get(0)?.items?.map { venueItem ->
                    venueItem.toVenueEntity()
                }
                venueList?.toTypedArray()?.let { it1 -> venuesDao.insertAll(*it1) }
                preferencesHelper.hasRequested = true
                this.page += 1
                true
            }
            .onError()
    }

    private fun getQueryParams(): MutableMap<String, String> {
        val queries = mutableMapOf<String, String>()
        queries["p"] = page.toString()
        queries["ll"] = preferencesHelper.lastLocation.toCoordinates()
        return queries
    }

    override fun loadLocations(): Flowable<VenuesDto> {
        return venuesDao.allVenues().map {
            it.toMutableList()
        }.map {
            VenuesDto(totalCount, it)
        }
            .onError()
    }

    override fun getVenueDetails(movieId: String): Single<VenueDetailsDto> =
        api.getVenueDetails(movieId)
}