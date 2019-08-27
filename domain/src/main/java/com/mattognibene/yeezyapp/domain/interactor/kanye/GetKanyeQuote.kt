package com.mattognibene.yeezyapp.domain.interactor.kanye

import com.mattognibene.yeezyapp.domain.KanyeRepository
import com.mattognibene.yeezyapp.domain.interactor.CoroutineUseCase
import javax.inject.Inject

class GetKanyeQuote @Inject constructor(
    private val repository: KanyeRepository
) : CoroutineUseCase<Unit, String>() {
    override suspend fun execute(params: Unit): String {
        return repository.getKanyeQuote()
    }
}