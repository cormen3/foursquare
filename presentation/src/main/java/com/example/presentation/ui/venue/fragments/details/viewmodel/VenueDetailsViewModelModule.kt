package com.example.presentation.ui.venue.fragments.details.viewmodel

import androidx.lifecycle.ViewModel
import com.example.presentation.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class VenueDetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(VenueDetailsViewModel::class)
    abstract fun viewModel(viewModelVenue: VenueDetailsViewModel): ViewModel
}