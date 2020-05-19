package com.example.presentation.base

import dagger.Module

@Module
abstract class BaseFragmentModule {
    @Module
    companion object {
        const val FRAGMENT = "BaseFragmentModule.fragment"
    }
}