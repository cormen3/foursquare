package com.example.data.repository

import com.example.common.error.ErrorThrowable
import com.example.common_test.TestUtil
import com.example.common_test.mock
import com.example.data.datasource.VenueDataSource
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyString

@RunWith(JUnit4::class)
class VenueDtoRepositoryImplTest {

    private var dataSource: VenueDataSource = mock()
    private lateinit var repository: VenueRepositoryImpl

    @Before
    fun setup() {
        this.repository = VenueRepositoryImpl(dataSource)
    }

    @Test
    fun `explore venues onSuccess`() {
        doReturn(Single.just(true)).whenever(dataSource)
            .exploreVenues(anyBoolean())

        repository.exploreVenues(true)
            .test()
            .assertNoErrors()
            .assertValue(true)
            .assertComplete()
    }

    @Test
    fun `explore venues onError`() {
        doReturn(Single.error<ErrorThrowable>(TestUtil.error())).whenever(dataSource)
            .exploreVenues(anyBoolean())

        repository.exploreVenues(true)
            .test()
            .assertNotComplete()
    }

    @Test
    fun `load locations onSuccess`() {
        doReturn(Flowable.just(TestUtil.fakeVenues())).whenever(dataSource)
            .loadLocations()

        repository.loadLocations()
            .test()
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun `load locations onError`() {
        doReturn(Flowable.error<ErrorThrowable>(TestUtil.error())).whenever(dataSource)
            .loadLocations()

        repository.loadLocations()
            .test()
            .assertNotComplete()
    }

    @Test
    fun `get venue details onSuccess`() {
        doReturn(Single.just(TestUtil.venueDetailsResponse())).whenever(dataSource)
            .getVenueDetails(anyString())

        repository.getVenueDetails(anyString())
            .test()
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun `get venue details onError`() {
        doReturn(Single.error<ErrorThrowable>(TestUtil.error())).whenever(dataSource)
            .getVenueDetails(anyString())

        repository.getVenueDetails(anyString())
            .test()
            .assertNotComplete()
    }
}
