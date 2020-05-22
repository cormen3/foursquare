package com.example.common_test.transformer

import com.example.domain.transformer.CTransformer
import io.reactivex.Completable
import io.reactivex.CompletableSource

class TestCTransformer : CTransformer() {
    override fun apply(upstream: Completable): CompletableSource {
        return upstream
    }
}