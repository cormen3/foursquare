package com.example.data.datasource

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Suppress("unused")
@Module
abstract class DataSourceImplModule {

    @Binds
    @Singleton
    abstract fun dataSourceHome(homeDataSourceImpl: VenueDataSourceImpl): VenueDataSource
}
