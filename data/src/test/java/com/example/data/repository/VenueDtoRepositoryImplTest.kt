package com.example.data.repository

import com.example.common.error.ErrorThrowable
import com.example.common_test.TestUtil
import com.example.data.datasource.VenueDataSource
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class VenueDtoRepositoryImplTest {

    private var dataSource: VenueDataSource = FakeVenueDataSource()
    private var dataSourceFailed: VenueDataSource = FailedVenueDataSource()
    private lateinit var repository: VenueRepositoryImpl
    private lateinit var repositoryFail: VenueRepositoryImpl

    @Before
    fun setup() {
        this.repository = VenueRepositoryImpl(dataSource)
        this.repositoryFail = VenueRepositoryImpl(dataSourceFailed)
    }

    @Test
    fun `explore venues onSuccess`() {
        repository.exploreVenues(true)
            .test()
            .assertValue(true)
            .assertComplete()
    }

    @Test
    fun `explore venues onError`() {
        try {
            repositoryFail.exploreVenues(true)
            Assert.fail("Should have thrown ErrorThrowable")
        } catch (e: ErrorThrowable) {
        }
        return
    }

    @Test
    fun `load locations onSuccess`() {
        repository.loadLocations()
            .test()
            .assertValue(TestUtil.fakeVenues()?.toVenuesObject())
            .assertComplete()
    }

    @Test
    fun `load locations onError`() {
        try {
            repositoryFail.loadLocations()
            Assert.fail("Should have thrown ErrorThrowable")
        } catch (e: ErrorThrowable) {
        }
        return
    }
}
