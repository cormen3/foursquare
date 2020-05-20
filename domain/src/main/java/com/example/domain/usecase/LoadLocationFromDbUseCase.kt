package com.example.domain.usecase

import com.example.domain.entity.venue.VenuesObject
import com.example.domain.repository.VenueRepository
import com.example.domain.transformer.FTransformer
import com.example.domain.usecase.base.UseCaseFlowable
import io.reactivex.Flowable
import javax.inject.Inject

class LoadLocationFromDbUseCase @Inject constructor(
    private val repository: VenueRepository,
    private val transformer: FTransformer<VenuesObject>
) : UseCaseFlowable<VenuesObject, Unit>() {

    override fun execute(param: Unit): Flowable<VenuesObject> =
        repository.loadLocations().compose(transformer)

}