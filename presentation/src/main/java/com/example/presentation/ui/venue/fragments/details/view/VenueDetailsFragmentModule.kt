package com.example.presentation.ui.venue.fragments.details.view

import androidx.fragment.app.Fragment
import com.example.presentation.base.BaseFragmentModule
import com.example.presentation.ui.venue.fragments.details.viewmodel.VenueDetailsViewModelModule
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module(
    includes = [
        BaseFragmentModule::class,
        VenueDetailsViewModelModule::class
    ]
)
abstract class VenueDetailsFragmentModule {
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    abstract fun fragment(detailsFragment: VenueDetailsFragment): Fragment
}