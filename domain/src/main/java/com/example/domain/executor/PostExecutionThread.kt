package com.example.domain.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun scheduler(): Scheduler
}