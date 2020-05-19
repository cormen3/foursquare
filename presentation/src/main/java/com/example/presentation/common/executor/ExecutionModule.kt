package com.example.presentation.common.executor

import com.example.domain.executor.PostExecutionThread
import dagger.Binds
import dagger.Module

@Module
abstract class ExecutionModule {
    @Binds
    abstract fun postExecutionThread(uiThread: UiThread): PostExecutionThread
}