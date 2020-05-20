package com.example.domain.transformer

import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.CompletableSource
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AsyncCTransformer @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : CTransformer() {
    override fun apply(upstream: Completable): CompletableSource =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())
}