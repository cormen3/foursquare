package com.example.domain.usecase

import com.example.domain.transformer.CTransformer
import com.example.domain.repository.VenueRepository
import com.example.domain.usecase.base.UseCaseCompletable
import io.reactivex.Completable
import javax.inject.Inject

class ExploreVenuesUseCase @Inject constructor(
    private val repository: VenueRepository,
    private val transformer: CTransformer
) : UseCaseCompletable<ExploreVenuesUseCase.Params>() {

    override fun execute(param: Params): Completable =
        repository.exploreVenues(param.isRefresh, param.coordinate).compose(transformer)

    data class Params(
        var isRefresh: Boolean,
        var coordinate: String
    )
}
