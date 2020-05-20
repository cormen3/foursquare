package com.example.common.preferences

import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
abstract class PreferencesModule {
    @Binds
    abstract fun appPreferences(appPreferences: AppPreferences): PreferencesHelper
}
