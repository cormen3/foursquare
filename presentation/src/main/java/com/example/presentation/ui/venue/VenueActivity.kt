package com.example.presentation.ui.venue

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseActivity

class VenueActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue)
    }

    override fun onSupportNavigateUp() =
        findNavController(this, R.id.navHostFragment).navigateUp()
}