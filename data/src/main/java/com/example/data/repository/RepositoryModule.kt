package com.example.data.repository

import com.example.data.datasource.DataSourceImplModule
import com.example.domain.repository.VenueRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Suppress("unused")
@Module(includes = [DataSourceImplModule::class])
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun venueRepository(
        authRepositoryImpl: VenueRepositoryImpl
    ): VenueRepository
}
