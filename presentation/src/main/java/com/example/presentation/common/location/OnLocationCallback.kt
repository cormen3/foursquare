package com.example.presentation.common.location

import android.location.Location

interface OnLocationCallback {
    fun onStartLocating()
    fun onNewLocation(location: Location?)
}
