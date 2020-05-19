package com.example.presentation.common.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.*
import com.example.common.viewmodel.Event
import com.example.common.viewmodel.EventObserver
import com.example.common.viewmodel.ViewModelProviderFactory

fun <T> LifecycleOwner.observe(liveData: LiveData<T>?, action: (t: T) -> Unit) {
    liveData?.observe(this, Observer { t -> action(t) })
}

fun <T> LifecycleOwner.observeEvent(liveData: LiveData<Event<T>>?, action: (T) -> Unit) {
    liveData?.observe(this, EventObserver(action))
}

inline fun <reified VM : ViewModel> FragmentActivity.viewModelProvider(provider: ViewModelProviderFactory) =
    ViewModelProviders.of(this, provider)[VM::class.java]

inline fun <reified VM : ViewModel> AppCompatActivity.viewModelProvider(provider: ViewModelProviderFactory) =
    ViewModelProviders.of(this, provider)[VM::class.java]

inline fun <reified VM : ViewModel> Fragment.viewModelProvider(provider: ViewModelProviderFactory) =
    ViewModelProviders.of(this, provider)[VM::class.java]

inline fun <reified VM : ViewModel> Fragment.fragmentViewModelProvider() =
    ViewModelProviders.of(this)[VM::class.java]

inline fun <reified VM : ViewModel> Fragment.activityViewModelProvider(provider: ViewModelProviderFactory) =
    ViewModelProviders.of(requireActivity(), provider)[VM::class.java]

inline fun <reified VM : ViewModel> Fragment.parentViewModelProvider(provider: ViewModelProviderFactory) =
    ViewModelProviders.of(parentFragment!!, provider)[VM::class.java]