package com.example.foursquare

import com.example.common.CommonModule
import com.example.data.DataModule
import com.example.domain.DomainModule
import com.example.presentation.PresentationModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        PresentationModule::class,
        DataModule::class,
        DomainModule::class,
        CommonModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}