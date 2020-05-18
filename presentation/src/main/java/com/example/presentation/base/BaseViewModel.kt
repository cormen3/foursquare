package com.example.presentation.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val disposable = CompositeDisposable()
    private val taggedDisposables = mutableMapOf<String, Disposable>()

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

    private fun handleError(error: Throwable) {}

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

    open fun onSaveState(bundle: Bundle) {}

    open fun onRestoreState(bundle: Bundle) {}
}
