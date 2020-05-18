package com.example.presentation.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment(), MessagePresenter {

    @Inject
    protected lateinit var activityContext: Context

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
    }

    override fun showMessage(message: MessageData) {
    }
}
