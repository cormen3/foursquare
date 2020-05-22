package com.example.presentation.ui.venue.fragments.list.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.common.extensions.orZero
import com.example.domain.entity.DomainObject
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
    val isLoading = MutableLiveData<Boolean>(false)
    val hasError = MutableLiveData<Boolean>(false)
    var mBundleRecyclerViewState: Bundle? = null

    private val _venueItems = MutableLiveData<MutableList<out DomainObject>>()
    val venueItems: MutableLiveData<MutableList<out DomainObject>> = _venueItems

    var totalCount: Int = 0

    init {
        observeLoadVenuesFromDb()
    }

    private fun observeLoadVenuesFromDb() {
        loadLocationFromDbUseCase.invoke()
            .subscribe({ response ->
                totalCount = response.totalCount
                if (response.Venues.size > 0)
                    _venueItems.value = response.Venues
            }, {})
            .track()
    }

    fun getData() {
        hasError.value = false
        isLoading.value = true
        exploreVenuesUseCase.invoke(ExploreVenuesUseCase.Params(false))
            .onError()
            .subscribe({
                isLoading.value = false
            }, {
                hasError.value = true
            })
            .track()
    }

    fun loadMoreObserver(loadMoreObservable: PublishSubject<LoadMoreState>) {
        loadMoreObservable.subscribe {
            if (it == LoadMoreState.LOAD) {
                if (_venueItems.value?.size.orZero() >= totalCount) {
                    loadMoreObservable.onNext(LoadMoreState.FINISH)
                } else {
                    getMoreVenues(loadMoreObservable)
                }
            }
        }.track()
    }

    private fun getMoreVenues(loadMoreObservable: PublishSubject<LoadMoreState>) {
        exploreVenuesUseCase.invoke(ExploreVenuesUseCase.Params(true))
            .onError()
            .subscribe({
                loadMoreObservable.onNext(LoadMoreState.NOT_LOAD)
            }, {
                loadMoreObservable.onNext(LoadMoreState.NOT_LOAD)
            })
            .track()
    }

    fun observeClicks(actions: Observable<BaseAction>) {
        actions.subscribe {
            clickObservable.value = it
        }.track()
    }
}


