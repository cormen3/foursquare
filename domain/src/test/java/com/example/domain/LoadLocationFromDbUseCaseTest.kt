package com.example.domain

import com.example.common.error.ErrorThrowable
import com.example.common_test.TestUtil
import com.example.common_test.mock
import com.example.common_test.transformer.TestFTransformer
import com.example.data.repository.toVenuesObject
import com.example.domain.repository.VenueRepository
import com.example.domain.usecase.LoadLocationFromDbUseCase
import com.example.domain.usecase.base.invoke
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoadLocationFromDbUseCaseTest {

    private val repository: VenueRepository = mock()
    private val useCase = LoadLocationFromDbUseCase(repository, TestFTransformer())

    @Test
    fun `execute onSuccess`() {
        doReturn(Flowable.just(TestUtil.fakeVenues()?.toVenuesObject())).whenever(repository)
            .loadLocations()

        useCase.invoke()
            .test()
            .assertValue(TestUtil.fakeVenues()?.toVenuesObject())
            .assertComplete()

        verify(repository).loadLocations()
    }

    @Test
    fun `execute onError`() {
        doReturn(Flowable.error<ErrorThrowable>(TestUtil.error()))
            .whenever(repository).loadLocations()

        useCase.invoke()
            .test()
            .assertNotComplete()

        verify(repository).loadLocations()
    }

}