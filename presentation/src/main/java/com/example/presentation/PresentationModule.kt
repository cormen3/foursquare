package com.example.presentation

import com.example.presentation.common.CommonModule
import dagger.Module

@Module(includes = [CommonModule::class])
abstract class PresentationModule {
}
