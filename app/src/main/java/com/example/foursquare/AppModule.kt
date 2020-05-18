package com.example.foursquare

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun application(application: App): Application
}
