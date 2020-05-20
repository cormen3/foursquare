package com.example.presentation.ui.venue.fragments.list.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.common.extensions.orZero
import com.example.domain.entity.DomainObject
import com.example.domain.entity.venue.VenuesObject
import com.example.domain.usecase.ExploreVenuesUseCase
import com.example.domain.usecase.LoadLocationFromDbUseCase
import com.example.domain.usecase.base.invoke
import com.example.presentation.base.BaseViewModel
import com.example.presentation.base.adapter.BaseAction
import com.example.presentation.base.adapter.LoadMoreState
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class VenuesViewModel @Inject constructor(
    private val exploreVenuesUseCase: ExploreVenuesUseCase,
    private val loadLocationFromDbUseCase: LoadLocationFromDbUseCase
) : BaseViewModel() {

    val clickObservable = MutableLiveData<BaseAction>()
    val venueItems = MutableLiveData<MutableList<DomainObject>>()
    var totalCount: Int = 0
    var coordinate: String? = null

    init {
        observeLoadVenuesFromDb()
    }

    private fun observeLoadVenuesFromDb() {
        loadLocationFromDbUseCase.invoke()
            .subscribe({ response ->
                (response as VenuesObject)
                totalCount = response.totalCount
                if (response.Venues.size > 0)
                    venueItems.value = response.Venues as? MutableList<DomainObject>
            }, {})
            .track()
    }

    fun getData() {
        coordinate?.let {
            exploreVenuesUseCase.invoke(ExploreVenuesUseCase.Params(true, it))
                .onError()
                .subscribe({}, {})
                .track()
        }
    }

    fun loadMoreObserver(loadMoreObservable: PublishSubject<LoadMoreState>) {
        loadMoreObservable.subscribe {
            if (it == LoadMoreState.LOAD) {
                if (venueItems.value?.size.orZero() >= totalCount) {
                    loadMoreObservable.onNext(LoadMoreState.FINISH)
                } else {
                    getMoreVenues(loadMoreObservable)
                }
            }
        }.track()
    }

    private fun getMoreVenues(loadMoreObservable: PublishSubject<LoadMoreState>) {
        coordinate?.let {
            exploreVenuesUseCase.invoke(ExploreVenuesUseCase.Params(false, it))
                .onError()
                .subscribe({
                    loadMoreObservable.onNext(LoadMoreState.NOT_LOAD)
                }, {
                    loadMoreObservable.onNext(LoadMoreState.NOT_LOAD)
                })
                .track()
        }
    }

    fun observeClicks(actions: Observable<BaseAction>) {
        actions.subscribe {
            clickObservable.value = it
        }.track()
    }
}


