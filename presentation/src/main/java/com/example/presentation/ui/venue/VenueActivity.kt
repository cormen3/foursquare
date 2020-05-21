package com.example.presentation.ui.venue

import android.content.Intent
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.example.common.viewmodel.ViewModelProviderFactory
import com.example.domain.entity.ActivityResultObject
import com.example.domain.entity.PermissionResultObject
import com.example.presentation.R
import com.example.presentation.base.BaseActivity
import com.example.presentation.common.extension.viewModelProvider
import javax.inject.Inject

class VenueActivity : BaseActivity() {

    private lateinit var viewModelVenue: VenueSharedViewModel
    @Inject
    lateinit var factory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue)
        viewModelVenue = viewModelProvider(factory)
    }

    override fun onSupportNavigateUp() =
        findNavController(this, R.id.navHostFragment).navigateUp()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModelVenue.setActivityResultData(ActivityResultObject(requestCode, resultCode, data))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        viewModelVenue.setPermissionResultData(PermissionResultObject(requestCode, permissions, grantResults))
    }
}

