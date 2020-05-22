package com.example.common_test.transformer

import com.example.domain.transformer.FTransformer
import io.reactivex.Flowable
import org.reactivestreams.Publisher

class TestFTransformer<T> : FTransformer<T>() {
    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream
    }
}