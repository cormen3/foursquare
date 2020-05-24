package com.example.presentation.common.location

import android.location.Location

interface OnLocationCallback {
    fun onNewLocation(location: Location?)
    fun onStateChanged(isRunning: Boolean)
}
