package com.example.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.common.error.ErrorThrowable
import com.example.common_test.TestUtil
import com.example.common_test.mock
import com.example.common_test.observe
import com.example.data.repository.toVenuesObject
import com.example.domain.entity.DomainObject
import com.example.domain.entity.venue.VenueInfoObject
import com.example.domain.usecase.ExploreVenuesUseCase
import com.example.domain.usecase.GetVenueDetailsUseCase
import com.example.domain.usecase.LoadLocationFromDbUseCase
import com.example.domain.usecase.base.invoke
import com.example.presentation.ui.venue.fragments.details.viewmodel.VenueDetailsViewModel
import com.example.presentation.ui.venue.fragments.list.viewmodel.VenuesViewModel
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.ArgumentMatchers.anyString

@RunWith(JUnit4::class)
class VenueDetailsViewModelTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val getVenueDetailsUseCase: GetVenueDetailsUseCase = mock()
    private lateinit var viewModel: VenueDetailsViewModel

    @Test
    fun `get Venues onSuccess`() {
        doReturn(Single.just(TestUtil.fakeVenueInfoObject())).whenever(getVenueDetailsUseCase)
            .invoke(anyString())

        val moviesObserver = mock<(VenueInfoObject) -> Unit>()
        viewModel = createViewModel()
        viewModel.venueInfo.observe(moviesObserver)

        viewModel.getMovieDetails()

        verify(moviesObserver, times(1)).invoke(any())
    }

    @Test
    fun `get Venues onError`() {
        doReturn(Single.error<ErrorThrowable>(TestUtil.error())).whenever(getVenueDetailsUseCase)
            .invoke(anyString())

        val moviesObserver = mock<(VenueInfoObject) -> Unit>()
        viewModel = createViewModel()
        viewModel.venueInfo.observe(moviesObserver)

        verify(moviesObserver, never()).invoke(any())
    }

    private fun createViewModel() = VenueDetailsViewModel(
        getVenueDetailsUseCase
    )
}
