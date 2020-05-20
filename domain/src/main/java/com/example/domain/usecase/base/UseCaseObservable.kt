package com.example.domain.usecase.base

import io.reactivex.Observable

abstract class UseCaseObservable<R, P> {
    operator fun invoke(param: P?): Observable<R> {
        return if (param != null) {
            execute(param)
        } else {
            Observable.error(IllegalArgumentException())
        }
    }
    protected abstract fun execute(param: P): Observable<R>
}

operator fun <R> UseCaseObservable<R, Unit>.invoke(): Observable<R> = this(Unit)