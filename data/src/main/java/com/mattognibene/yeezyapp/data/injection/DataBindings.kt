package com.mattognibene.yeezyapp.data.injection

import com.mattognibene.yeezyapp.data.DefaultKanyeRepository
import com.mattognibene.yeezyapp.domain.KanyeRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataBindings {

    @Binds
    abstract fun kanyeRepository(repository: DefaultKanyeRepository): KanyeRepository
}