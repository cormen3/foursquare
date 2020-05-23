package com.example.domain.usecase

import com.example.domain.entity.venue.VenueInfoObject
import com.example.domain.repository.VenueRepository
import com.example.domain.transformer.STransformer
import com.example.domain.usecase.base.UseCaseSingle
import io.reactivex.Single
import javax.inject.Inject

class GetVenueDetailsUseCase @Inject constructor(
    private val repository: VenueRepository,
    private val transformer: STransformer<VenueInfoObject>
) : UseCaseSingle<VenueInfoObject, String>() {

    override fun execute(param: String): Single<VenueInfoObject> =
        repository.getVenueDetails(param).compose(transformer)
}