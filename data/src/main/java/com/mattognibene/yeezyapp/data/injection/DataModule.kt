package com.mattognibene.yeezyapp.data.injection

import com.mattognibene.yeezyapp.cache.room.DatabaseModule
import com.mattognibene.yeezyapp.domain.executors.AppExecutors
import com.mattognibene.yeezyapp.remote.NetworkModule

import java.util.concurrent.Executors

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module(includes = [DatabaseModule::class, NetworkModule::class, DataBindings::class])
object DataModule {
    @Provides
    @JvmStatic
    fun providesExecutors(): AppExecutors {
        return object : AppExecutors {
            override fun diskIo(): Scheduler {
                return Schedulers.from(Executors.newFixedThreadPool(3))
            }

            override fun networkIo(): Scheduler {
                return Schedulers.io()
            }

            override fun mainThread(): Scheduler {
                return AndroidSchedulers.mainThread()
            }
        }
    }
}
