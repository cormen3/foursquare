package com.example.presentation.ui.venue.fragments.list.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.presentation.base.BaseViewModel
import com.example.presentation.base.adapter.BaseAction
import io.reactivex.Observable
import javax.inject.Inject

class VenuesViewModel @Inject constructor() : BaseViewModel() {

    val clickObservable = MutableLiveData<BaseAction>()

    fun observeClicks(actions: Observable<BaseAction>) {
        actions.subscribe {
            clickObservable.value = it
        }.track()
    }
}


