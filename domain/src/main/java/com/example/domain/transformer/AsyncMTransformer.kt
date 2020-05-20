package com.example.domain.transformer

import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import io.reactivex.Maybe
import io.reactivex.MaybeSource
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AsyncMTransformer<T> @Inject constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : MTransformer<T>() {
    override fun apply(upstream: Maybe<T>): MaybeSource<T> =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())
}