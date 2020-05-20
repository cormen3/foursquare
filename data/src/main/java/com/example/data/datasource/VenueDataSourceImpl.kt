package com.example.data.datasource

import com.example.data.entity.VenuesDao
import com.example.data.entity.model.dto.Venues
import com.example.data.extension.onError
import com.example.data.network.VenueDataService
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class VenueDataSourceImpl @Inject constructor(
    private val api: VenueDataService,
    private val venuesDao: VenuesDao
) : VenueDataSource {

    @Volatile
    private var page: Int = 1

    private var totalCount: Int = 0

    private lateinit var queries: MutableMap<String, String>

    override fun exploreVenues(isRefresh: Boolean, coordinate:String): Completable {
        return getAndInsert(isRefresh, coordinate)
    }

    private fun getAndInsert(isRefresh: Boolean, coordinate:String): Completable {
        return Observable.fromCallable {
            initQuery(coordinate)
        }.flatMapCompletable {
            api.exploreVenues(queries)
                .doOnNext {
                    if (isRefresh)
                        venuesDao.clearAll()
                }
                .map {
                    totalCount = it.response.totalResults
                    val venueList = it.response.groups[0].items.map { it.toVenueEntity() }
                    venuesDao.insertAll(*venueList.toTypedArray())
                    this.page += 1
                    it
                }
                .ignoreElements()
                .onError()
        }
    }

    private fun initQuery(coordinate:String) {
        queries = mutableMapOf()
        queries["p"] = page.toString()
        queries["ll"] = coordinate
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
