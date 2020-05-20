package com.example.domain.usecase.base

import io.reactivex.Single

abstract class UseCaseSingle<R, P> {
    operator fun invoke(param: P?): Single<R> {
        return if (param != null) {
            execute(param)
        } else {
            Single.error(IllegalArgumentException())
        }
    }
    protected abstract fun execute(param: P): Single<R>
}

operator fun <R> UseCaseSingle<R, Unit>.invoke(): Single<R> = this(Unit)