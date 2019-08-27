package com.mattognibene.yeezyapp.remote

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

@Module(includes = [NetworkSettings::class])
object NetworkModule {
    @Provides
    @JvmStatic
    fun providesKanyeApi(
        builder: Retrofit.Builder
    ): KanyeApi {
        val url = requireNotNull(HttpUrl.parse("https://api.kanye.rest"))
        return builder.baseUrl(url)
                .build()
                .create(KanyeApi::class.java)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providesRetrofit(level: HttpLoggingInterceptor.Level): Retrofit.Builder {
        val logging = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").v(message) }
            .apply { this.level = level }

        val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

        val moshi = Moshi.Builder().build()

        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }
}