package com.example.common_test

import androidx.lifecycle.LiveData
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

inline fun <reified T> mock(): T = Mockito.mock(T::class.java)

inline fun <reified T> argumentCaptor(): ArgumentCaptor<T> = ArgumentCaptor.forClass(T::class.java)

fun <T> LiveData<T>.observeOnce(onChangeHandler: (T) -> Unit) {
    val observer = OneTimeObserver(handler = onChangeHandler)
    observe(observer, observer)
}

fun <T> LiveData<T>.observe(onChangeHandler: (T) -> Unit) {
    val observer = UnlimitedObserver(handler = onChangeHandler)
    observe(observer, observer)
}

fun <T> any(): T {
    Mockito.any<T>()
    return uninitialized()
}
@Suppress("UNCHECKED_CAST")
private fun <T> uninitialized(): T = null as T

fun <T> ArgumentCaptor<T>.captureSafe(): T {
    this.capture()
    return uninitialized()
}

fun <T> eq(t: T): T {
    return Mockito.eq<T>(t) as T
}
