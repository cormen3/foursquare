package com.example.data.executor

import com.example.domain.executor.ThreadExecutor
import dagger.Binds
import dagger.Module

@Module
abstract class ExecutionModule {
    @Binds
    abstract fun threadExecutor(jobExecutor: JobExecutor): ThreadExecutor
}