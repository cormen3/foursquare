package com.example.presentation.common.connection

interface ConnectionStatusCallback {
    fun onConnectionChanged(isConnected: Boolean)
}
