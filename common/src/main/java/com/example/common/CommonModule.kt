package com.example.common

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.common.preferences.PreferencesModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        PreferencesModule::class]
)
abstract class CommonModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        fun sharedPreferences(application: Application): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(application)
        }
    }
}
