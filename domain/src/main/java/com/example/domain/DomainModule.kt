package com.example.domain

import com.example.domain.entity.venue.VenueInfoObject
import com.example.domain.entity.venue.VenueObject
import com.example.domain.entity.venue.VenuesObject
import com.example.domain.transformer.*
import dagger.Binds
import dagger.Module

@Suppress("unused")
@Module
abstract class DomainModule {
    @Binds
    abstract fun completableTransformer(
        transformer: AsyncCTransformer
    ): CTransformer

    @Binds
    abstract fun intSTransformer(
        transformer: AsyncSTransformer<Boolean>
    ): STransformer<Boolean>

    @Binds
    abstract fun venueInfoSTransformer(
        transformer: AsyncSTransformer<VenueInfoObject>
    ): STransformer<VenueInfoObject>

    @Binds
    abstract fun venuesTransformer(
        transformer: AsyncSTransformer<List<VenueObject>>
    ): STransformer<List<VenueObject>>

    @Binds
    abstract fun venueFTransformer(
        transformer: AsyncFTransformer<VenuesObject>
    ): FTransformer<VenuesObject>
}
