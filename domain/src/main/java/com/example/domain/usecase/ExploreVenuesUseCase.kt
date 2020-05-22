package com.example.domain.usecase

import com.example.domain.repository.VenueRepository
import com.example.domain.transformer.STransformer
import com.example.domain.usecase.base.UseCaseSingle
import io.reactivex.Single
import javax.inject.Inject

class ExploreVenuesUseCase @Inject constructor(
    private val repository: VenueRepository,
    private val transformer: STransformer<Boolean>
) : UseCaseSingle<Boolean, ExploreVenuesUseCase.Params>() {

    override fun execute(param: Params): Single<Boolean> =
        repository.exploreVenues(param.isLoadMore).compose(transformer)

    data class Params(
        var isLoadMore: Boolean
    )
}
