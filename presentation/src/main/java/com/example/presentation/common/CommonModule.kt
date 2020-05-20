package com.example.presentation.common

import com.example.presentation.common.executor.ExecutionModule
import dagger.Module

@Module(includes = [ExecutionModule::class])
abstract class CommonModule