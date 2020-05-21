package com.example.presentation.ui.venue.fragments.list.view

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.extensions.safeLet
import com.example.common.viewmodel.ViewModelProviderFactory
import com.example.domain.entity.ActivityResultObject
import com.example.domain.entity.PermissionResultObject
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.base.adapter.BaseAction
import com.example.presentation.common.extension.goneOrVisible
import com.example.presentation.common.extension.observe
import com.example.presentation.common.extension.viewModelProvider
import com.example.presentation.common.location.LocationManager
import com.example.presentation.common.location.OnLocationCallback
import com.example.presentation.ui.venue.VenueSharedViewModel
import com.example.presentation.ui.venue.fragments.list.view.adapter.VenuesAdapter
import com.example.presentation.ui.venue.fragments.list.viewmodel.VenuesViewModel
import kotlinx.android.synthetic.main.fragment_venues.*
import javax.inject.Inject

class VenuesFragment : BaseFragment(), OnLocationCallback {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    @Inject
    lateinit var locationManager: LocationManager

    private lateinit var viewModel: VenuesViewModel
    private lateinit var sharedViewModel: VenueSharedViewModel
    private lateinit var venuesAdapter: VenuesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModelProvider(factory)
        sharedViewModel = viewModelProvider(factory)
        activity?.let {
            sharedViewModel = it.viewModelProvider(factory)
        }

        venuesAdapter = VenuesAdapter { holder ->
            viewModel.observeClicks(holder.observe())
        }

        observe(viewModel.clickObservable, ::observeActions)
        observe(viewModel.messageObservable, ::showMessage)
        observe(viewModel.venueItems, venuesAdapter::addItems)
        observe(viewModel.isLoading, ::handleLoading)
        observe(sharedViewModel.activityResultData, ::observeActivityResultData)
        observe(sharedViewModel.permissionResultData, ::observePermissionResultData)

        viewModel.loadMoreObserver(venuesAdapter.getLoadMoreObservable())
        locationManager.enable(forceDetectLocation = true, showRational = true)
    }

    private fun handleLoading(show: Boolean) {
        loading.goneOrVisible(show)
    }

    private fun observePermissionResultData(permissionResultObject: PermissionResultObject?) {
        safeLet(
            permissionResultObject?.requestCode,
            permissionResultObject?.grantResults
        ) { requestCode, permissionResult ->
            locationManager.onRequestPermissionsResult(requestCode, permissionResult)
        }
    }

    private fun observeActivityResultData(activityResultObject: ActivityResultObject?) {
        safeLet(
            activityResultObject?.requestCode,
            activityResultObject?.resultCode
        ) { requestCode, resultCode ->
            locationManager.onActivityResult(requestCode, resultCode)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_venues, container, false)

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        setupList()
    }

    private fun setupList() {
        venuesRecyclerView.apply {
            layoutManager = LinearLayoutManager(venuesRecyclerView.context)
            adapter = venuesAdapter
        }
    }

    override fun onNewLocation(location: Location?) {
        location?.let {
            viewModel.coordinate =
                location.latitude.toString().plus(",").plus(location.longitude.toString())
            viewModel.getData()
        }
    }

    private fun observeActions(action: BaseAction) {
    }
}
