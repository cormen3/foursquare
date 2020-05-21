package com.example.presentation.ui.venue.fragments.list.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.presentation.base.BaseFragmentModule
import com.example.presentation.common.connection.ConnectionStatusCallback
import com.example.presentation.common.location.OnLocationCallback
import com.example.presentation.ui.venue.fragments.list.viewmodel.VenuesViewModelModule
import com.example.presentation.ui.venue.fragments.list.view.VenuesFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = [
        BaseFragmentModule::class,
        VenuesViewModelModule::class
    ]
)
abstract class VenuesFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    abstract fun fragment(venuesFragment: VenuesFragment): Fragment

    @Binds
    abstract fun locationCallback(venuesFragment: VenuesFragment): OnLocationCallback

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideLifecycle(venuesFragment: VenuesFragment): Lifecycle =
            venuesFragment.lifecycle
    }
}