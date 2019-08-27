package com.mattognibene.yeezyapp.data

import com.mattognibene.yeezyapp.domain.KanyeRepository
import com.mattognibene.yeezyapp.remote.KanyeApi
import javax.inject.Inject

class DefaultKanyeRepository @Inject constructor(
    private val api: KanyeApi
) : KanyeRepository {
    override suspend fun getKanyeQuote(): String {
        return api.getKanyeQuote().quote
    }
}