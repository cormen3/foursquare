package com.example.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.common.error.ErrorThrowable
import com.example.common_test.TestUtil
import com.example.common_test.mock
import com.example.common_test.observe
import com.example.data.repository.toVenuesObject
import com.example.domain.entity.DomainObject
import com.example.domain.usecase.ExploreVenuesUseCase
import com.example.domain.usecase.LoadLocationFromDbUseCase
import com.example.domain.usecase.base.invoke
import com.example.presentation.ui.venue.fragments.list.viewmodel.VenuesViewModel
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyBoolean

@RunWith(JUnit4::class)
class VenuesDtoViewModelTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val exploreVenuesUseCase: ExploreVenuesUseCase = mock()
    private val loadLocationFromDbUseCase: LoadLocationFromDbUseCase = mock()

    private lateinit var viewModel: VenuesViewModel

    @Test
    fun `get Venues onSuccess`() {
        doReturn(Single.just(true)).whenever(exploreVenuesUseCase)
            .invoke(ExploreVenuesUseCase.Params(anyBoolean()))

        doReturn(Flowable.just(TestUtil.fakeVenues()?.toVenuesObject())).whenever(
            loadLocationFromDbUseCase
        ).invoke()

        val moviesObserver = mock<(MutableList<out DomainObject>) -> Unit>()
        viewModel = createViewModel()
        viewModel.venueItems.observe(moviesObserver)

        verify(moviesObserver, times(1)).invoke(any())
    }

    @Test
    fun `get Venues onError`() {
        doReturn(Single.error<ErrorThrowable>(TestUtil.error())).whenever(exploreVenuesUseCase)
            .invoke(ExploreVenuesUseCase.Params(anyBoolean()))

        doReturn(Flowable.error<ErrorThrowable>(TestUtil.error())).whenever(
            loadLocationFromDbUseCase
        ).invoke()

        val moviesObserver = mock<(MutableList<out DomainObject>) -> Unit>()
        viewModel = createViewModel()
        viewModel.venueItems.observe(moviesObserver)

        verify(moviesObserver, never()).invoke(any())
    }

    private fun createViewModel() = VenuesViewModel(
        exploreVenuesUseCase,
        loadLocationFromDbUseCase
    )
}
