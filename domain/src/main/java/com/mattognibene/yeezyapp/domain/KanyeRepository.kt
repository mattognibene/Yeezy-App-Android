package com.mattognibene.yeezyapp.domain

interface KanyeRepository {
    suspend fun getKanyeQuote(): String
}