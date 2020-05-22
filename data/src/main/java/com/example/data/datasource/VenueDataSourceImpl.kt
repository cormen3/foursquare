package com.example.data.datasource

import com.example.common.preferences.PreferencesHelper
import com.example.data.entity.VenuesDao
import com.example.data.entity.model.dto.Venues
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
                totalCount = it.response.totalResults
                val venueList = it.response.groups[0].items.map { venueItem ->
                    venueItem.toVenueEntity()
                }
                venuesDao.insertAll(*venueList.toTypedArray())
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

    override fun loadLocations(): Flowable<Venues> {
        return venuesDao.allVenues().map {
            it.toMutableList()
        }.map {
            Venues(totalCount, it)
        }
            .onError()
    }
}