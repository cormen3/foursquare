package com.example.presentation.ui.venue.fragments.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.viewmodel.ViewModelProviderFactory
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.base.adapter.BaseAction
import com.example.presentation.common.extension.observe
import com.example.presentation.common.extension.viewModelProvider
import com.example.presentation.ui.venue.fragments.list.view.adapter.VenuesAdapter
import com.example.presentation.ui.venue.fragments.list.viewmodel.VenuesViewModel
import kotlinx.android.synthetic.main.fragment_venues.*
import javax.inject.Inject

class VenuesFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: VenuesViewModel
    private lateinit var venuesAdapter: VenuesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModelProvider(factory)
        venuesAdapter = VenuesAdapter { holder ->
            viewModel.observeClicks(holder.observe())
        }
        observe(viewModel.clickObservable, ::observeActions)
        observe(viewModel.messageObservable, ::showMessage)
        viewModel.loadMoreObserver(venuesAdapter.getLoadMoreObservable())
        observe(viewModel.venueItems, venuesAdapter::addItems)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_venues, container, false)

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        setupList()

        viewModel.coordinate = "40.7243,-74.0018"
        viewModel.getData()
    }

    private fun setupList() {
        venuesRecyclerView.apply {
            layoutManager = LinearLayoutManager(venuesRecyclerView.context)
            adapter = venuesAdapter
        }
    }

    private fun observeActions(action: BaseAction) {
    }
}
