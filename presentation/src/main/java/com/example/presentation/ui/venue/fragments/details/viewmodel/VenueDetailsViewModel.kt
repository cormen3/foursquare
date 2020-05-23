package com.example.presentation.ui.venue.fragments.details.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.venue.VenueInfoObject
import com.example.domain.usecase.GetVenueDetailsUseCase
import com.example.presentation.base.BaseViewModel
import javax.inject.Inject

class VenueDetailsViewModel @Inject constructor(
    private val getVenueDetailsUseCase: GetVenueDetailsUseCase
) : BaseViewModel() {

    var venueInfo = MutableLiveData<VenueInfoObject>()
    var venueId = MutableLiveData<String>()

    fun getMovieDetails() {
        getVenueDetailsUseCase.invoke(venueId.value.toString()).onError()
            .subscribe({
            venueInfo.value = it
        }, {
        }).track()
    }
}