package com.example.presentation.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.presentation.common.connection.ConnectionManager
import com.example.presentation.common.extension.toast
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment(), MessagePresenter {

    @Inject
    protected lateinit var activityContext: Context

    @Inject
    lateinit var connectionManager: ConnectionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun showMessage(@StringRes resourceId: Int) {
        showMessage(getString(resourceId))
    }

    override fun showMessage(message: String) {
        activity?.applicationContext?.toast(message, Toast.LENGTH_SHORT)
    }
}
