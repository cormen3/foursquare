package com.example.presentation.ui.venue.fragments.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common.viewmodel.ViewModelProviderFactory
import com.example.domain.entity.venue.VenueInfoObject
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.common.extension.observe
import com.example.presentation.common.extension.viewModelProvider
import com.example.presentation.ui.venue.fragments.details.viewmodel.VenueDetailsViewModel
import com.example.presentation.ui.venue.fragments.list.view.VenuesFragment.Companion.VENUE_ID
import javax.inject.Inject

class VenueDetailsFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: VenueDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModelProvider(factory)
        observe(viewModel.messageObservable, ::showMessage)
        observe(viewModel.venueInfo, ::updateInfo)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_venue_details, container, false)

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        arguments?.getString(VENUE_ID)?.let {
            viewModel.venueId.value = it
            viewModel.getMovieDetails()
        }
    }

    private fun updateInfo(venueInfoObject: VenueInfoObject?) {
    }
}
