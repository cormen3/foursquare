package com.example.domain.usecase.base

import io.reactivex.Maybe

abstract class UseCaseMaybe<R, P> {
    operator fun invoke(param: P?): Maybe<R> {
        return if (param != null) {
            execute(param)
        } else {
            Maybe.error(IllegalArgumentException())
        }
    }
    protected abstract fun execute(param: P): Maybe<R>
}

operator fun <R> UseCaseMaybe<R, Unit>.invoke(): Maybe<R> = this(Unit)