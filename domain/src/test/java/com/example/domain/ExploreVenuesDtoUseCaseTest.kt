package com.example.domain

import com.example.common.error.ErrorThrowable
import com.example.common_test.TestUtil
import com.example.common_test.mock
import com.example.common_test.transformer.TestSTransformer
import com.example.domain.repository.VenueRepository
import com.example.domain.usecase.ExploreVenuesUseCase
import com.example.domain.usecase.base.invoke
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyBoolean

@RunWith(JUnit4::class)
class ExploreVenuesDtoUseCaseTest {

    private val repository: VenueRepository = mock()
    private val useCase = ExploreVenuesUseCase(repository, TestSTransformer())

    @Test
    fun `execute onSuccess`() {
        doReturn(Single.just(true)).whenever(repository).exploreVenues(anyBoolean())

        useCase.invoke(ExploreVenuesUseCase.Params(true))
            .test()
            .assertComplete()

        verify(repository).exploreVenues(true)
    }

    @Test
    fun `execute onError`() {
        doReturn(Single.error<ErrorThrowable>(TestUtil.error()))
            .whenever(repository).exploreVenues(anyBoolean())

        useCase.invoke(ExploreVenuesUseCase.Params(true))
            .test()
            .assertNotComplete()

        verify(repository).exploreVenues(true)
    }

}