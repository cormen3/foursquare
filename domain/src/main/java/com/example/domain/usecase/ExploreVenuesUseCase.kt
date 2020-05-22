package com.example.domain.usecase

import com.example.domain.repository.VenueRepository
import com.example.domain.transformer.CTransformer
import com.example.domain.transformer.STransformer
import com.example.domain.usecase.base.UseCaseCompletable
import com.example.domain.usecase.base.UseCaseSingle
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ExploreVenuesUseCase @Inject constructor(
    private val repository: VenueRepository,
    private val transformer: STransformer<Boolean>
) : UseCaseSingle<Boolean, ExploreVenuesUseCase.Params>() {

    override fun execute(param: Params): Single<Boolean> =
        repository.exploreVenues(param.isRefresh).compose(transformer)

    data class Params(
        var isRefresh: Boolean
    )
}
