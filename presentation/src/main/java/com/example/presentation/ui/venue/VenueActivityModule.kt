package com.example.presentation.ui.venue

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.presentation.base.BaseActivityModule
import com.example.presentation.common.di.ViewModelKey
import com.example.presentation.ui.venue.fragments.details.view.VenueDetailsFragment
import com.example.presentation.ui.venue.fragments.details.view.VenueDetailsFragmentModule
import com.example.presentation.ui.venue.fragments.list.view.VenuesFragment
import com.example.presentation.ui.venue.fragments.list.view.VenuesFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        BaseActivityModule::class
    ]
)
abstract class VenueActivityModule {

    @Binds
    abstract fun appCompatActivity(venueActivity: VenueActivity): AppCompatActivity

    @ContributesAndroidInjector(modules = [VenuesFragmentModule::class])
    abstract fun venueFragmentInjector(): VenuesFragment

    @ContributesAndroidInjector(modules = [VenueDetailsFragmentModule::class])
    abstract fun detailsFragmentInjector(): VenueDetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(VenueSharedViewModel::class)
    abstract fun viewModel(viewModelVenue: VenueSharedViewModel): ViewModel
}