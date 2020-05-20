package com.example.presentation.ui.venue

import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.base.BaseActivityModule
import com.example.presentation.ui.venue.fragments.list.view.VenuesFragmentModule
import com.example.presentation.ui.venue.fragments.list.view.VenuesFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [BaseActivityModule::class]
)
abstract class VenueActivityModule {

    @Binds
    abstract fun appCompatActivity(venueActivity: VenueActivity): AppCompatActivity

    @ContributesAndroidInjector(modules = [VenuesFragmentModule::class])
    abstract fun venueFragmentInjector(): VenuesFragment
}