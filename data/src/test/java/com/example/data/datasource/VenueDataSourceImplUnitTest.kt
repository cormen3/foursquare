package com.example.data.datasource

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.common.error.ErrorThrowable
import com.example.common.preferences.PreferencesHelper
import com.example.common_test.TestUtil
import com.example.common_test.mock
import com.example.data.local.VenuesDao
import com.example.data.network.VenueDataService
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class VenueDataSourceImplUnitTest {

    @get:Rule // used to make all live data calls sync
    val instantExecutor = InstantTaskExecutorRule()

    private val preferencesHelper: PreferencesHelper = mock()
    private val venuesDao: VenuesDao = mock()
    private val api: VenueDataService = mock()

    private lateinit var dataSource: VenueDataSourceImpl

    @Before
    fun setup() {
        this.dataSource = spy(VenueDataSourceImpl(api, venuesDao, preferencesHelper))
    }

    @Test
    fun `get venues onSuccess`() {
        doReturn(Single.just(TestUtil.venuesResponse())).whenever(api)
            .exploreVenues(anyMap(), anyLong())

        dataSource.exploreVenues(true)
            .test()
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun `get venues onError`() {
        doReturn(Single.error<ErrorThrowable>(TestUtil.error())).whenever(api)
            .exploreVenues(anyMap(), anyLong())

        dataSource.exploreVenues(true)
            .test()
            .assertNotComplete()
    }

    @Test
    fun `get venue details onSuccess`() {
        doReturn(Single.just(TestUtil.venueDetailsResponse())).whenever(api)
            .getVenueDetails(anyString())

        dataSource.getVenueDetails(anyString())
            .test()
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun `get venue details onError`() {
        doReturn(Single.error<ErrorThrowable>(TestUtil.error())).whenever(api)
            .getVenueDetails(anyString())

        dataSource.getVenueDetails(anyString())
            .test()
            .assertNotComplete()
    }

}
