package com.example.foursquare

import android.app.Application
import com.example.presentation.ui.venue.VenueActivity
import com.example.presentation.ui.venue.VenueActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun application(application: App): Application

    @ContributesAndroidInjector(modules = [VenueActivityModule::class])
    abstract fun venueActivityInjector(): VenueActivity
}
