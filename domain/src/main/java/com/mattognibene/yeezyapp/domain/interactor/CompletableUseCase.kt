package com.mattognibene.yeezyapp.domain.interactor

import io.reactivex.Completable

abstract class CompletableUseCase<in T> : BaseUseCase<T, Completable>()