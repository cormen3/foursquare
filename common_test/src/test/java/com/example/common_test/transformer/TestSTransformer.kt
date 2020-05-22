package com.example.common_test.transformer

import com.example.domain.transformer.STransformer
import io.reactivex.Single
import io.reactivex.SingleSource

class TestSTransformer<T> : STransformer<T>() {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
    }
}