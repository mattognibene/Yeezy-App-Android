package com.mattognibene.yeezyapp.remote

import com.mattognibene.yeezyapp.remote.model.KanyeQuoteResponse
import retrofit2.http.GET

interface KanyeApi {
    @GET(".") suspend fun getKanyeQuote(): KanyeQuoteResponse
}