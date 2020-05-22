package com.example.data.datasource

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.common.error.ErrorThrowable
import com.example.common.preferences.PreferencesHelper
import com.example.common_test.mock
import com.example.data.entity.VenuesDao
import com.example.data.network.VenueDataService
import com.nhaarman.mockitokotlin2.spy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class VenueDataSourceImplUnitTest {

    @Suppress("unused")
    @get:Rule // used to make all live data calls sync
    val instantExecutor = InstantTaskExecutorRule()

    private val preferencesHelper: PreferencesHelper = mock()
    private val venuesDao: VenuesDao = mock()
    private val api: VenueDataService = FakeVenueApi()
    private val failedApi: VenueDataService = FailedVenueApi()

    private lateinit var dataSource: VenueDataSourceImpl
    private lateinit var dataSourceFail: VenueDataSourceImpl

    @Before
    fun setup() {
        this.dataSource = spy(VenueDataSourceImpl(api, venuesDao, preferencesHelper))
        this.dataSourceFail = spy(VenueDataSourceImpl(failedApi, venuesDao, preferencesHelper))
    }

    @Test
    fun `get venues onSuccess`() {
        dataSource.exploreVenues(true)
            .test()
            .assertValue(true)
    }

    @Test
    fun `get venues onError`() {
        try {
            dataSourceFail.exploreVenues(true)
            Assert.fail("Should have thrown ErrorThrowable")
        } catch (e: ErrorThrowable) {
        }
        return
    }
}
