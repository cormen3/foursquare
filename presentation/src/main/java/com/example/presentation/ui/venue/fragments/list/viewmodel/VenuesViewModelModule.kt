package com.example.presentation.ui.venue.fragments.list.viewmodel

import androidx.lifecycle.ViewModel
import com.example.presentation.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class VenuesViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(VenuesViewModel::class)
    abstract fun viewModel(viewModel: VenuesViewModel): ViewModel
}