package com.example.domain.usecase.base

import io.reactivex.Completable

abstract class UseCaseCompletable<P> {
    operator fun invoke(param: P?): Completable {
        return if (param != null) {
            execute(param)
        } else {
            Completable.error(IllegalArgumentException())
        }
    }
    protected abstract fun execute(param: P): Completable
}

operator fun UseCaseCompletable<Unit>.invoke(): Completable = this(Unit)