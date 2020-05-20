package com.example.data.network

import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class NetworkModule {
    @Provides
    @Reusable
    fun venueDataService(dataServiceFactory: DataServiceFactory) =
        dataServiceFactory.create(VenueDataService::class.java)
}

