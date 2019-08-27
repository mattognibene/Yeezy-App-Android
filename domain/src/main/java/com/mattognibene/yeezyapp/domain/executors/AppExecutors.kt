package com.mattognibene.yeezyapp.domain.executors

import io.reactivex.Scheduler

interface AppExecutors {
    fun diskIo(): Scheduler
    fun networkIo(): Scheduler
    fun mainThread(): Scheduler
}