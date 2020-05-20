package com.example.presentation.common.connection

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import javax.inject.Inject

class ConnectionManager @Inject constructor(
    private val activity: AppCompatActivity,
    private val lifecycle: Lifecycle,
    private val connectionStatusCallback: ConnectionStatusCallback
) : LifecycleObserver, NetworkStateReceiver.NetworkStateReceiverListener {

    lateinit var networkStateReceiver: NetworkStateReceiver
    private var enabled = false

    init {
        lifecycle.addObserver(this)
        enabled = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled && ::networkStateReceiver.isInitialized) {
            networkStateReceiver = NetworkStateReceiver()
            networkStateReceiver.addListener(this)
            activity.registerReceiver(
                networkStateReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            )
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        if (enabled && ::networkStateReceiver.isInitialized) {
            networkStateReceiver.removeListener(this)
            activity.unregisterReceiver(networkStateReceiver)
        }
    }

    override fun networkAvailable() {
        connectionStatusCallback.onConnectionChanged(true)
    }

    override fun networkUnavailable() {
        connectionStatusCallback.onConnectionChanged(false)
    }

}