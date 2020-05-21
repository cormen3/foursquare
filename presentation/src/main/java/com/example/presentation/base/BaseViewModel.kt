package com.example.presentation.base

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.common.error.ErrorHandler
import com.example.common.error.ErrorMessage
import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseViewModel : ViewModel() {

    private var isConnected = true

    private val disposable = CompositeDisposable()
    private val taggedDisposables = mutableMapOf<String, Disposable>()
    val messageObservable: MutableLiveData<String> = MutableLiveData()

    protected fun Disposable.track(tag: String? = null): Disposable {
        disposable.add(this)
        tag?.let {
            dispose(it)
            taggedDisposables[it] = this
        }
        return this
    }

    private fun Disposable.unTrack() {
        disposable.remove(this)
    }

    private fun dispose(tag: String) {
        taggedDisposables[tag]?.let {
            it.unTrack()
            it.dispose()
            taggedDisposables.remove(tag)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    private fun handleError(error: Throwable) {

        var errorMessage = ErrorHandler.getError(error)

        if (!isConnected) {
            errorMessage = ErrorMessage.ERROR_NO_NET
        }

        messageObservable.value = errorMessage
    }

    protected fun <T> Flowable<T>.onError(): Flowable<T> =
        this.doOnError(::handleError)

    protected fun <T> Observable<T>.onError(): Observable<T> =
        this.doOnError(::handleError)

    protected fun <T> Single<T>.onError(): Single<T> =
        this.doOnError(::handleError)

    protected fun Completable.onError(): Completable =
        this.doOnError(::handleError)

    protected fun <T> Maybe<T>.onError(): Maybe<T> =
        this.doOnError(::handleError)

    fun setConnection(connected: Boolean) {
        isConnected = connected
    }

    open fun onSaveState(bundle: Bundle) {}

    open fun onRestoreState(bundle: Bundle) {}
}
