package com.example.data.network

import com.example.data.BuildConfig
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DataServiceFactory @Inject constructor() {
    fun <T> create(serviceClass: Class<T>): T =
        retrofit(TIME_OUT_API).create(serviceClass)

    private fun retrofit(type: Long): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClientBuilder(type).build())
        .build()

    private fun okHttpClientBuilder(timeout: Long): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT_CONNECTION, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(AuthInterceptor())
            .addInterceptor(httpLoggingInterceptor())

        builder.addNetworkInterceptor(StethoInterceptor())
        return builder
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    companion object {
        const val TIME_OUT_CONNECTION: Long = 30
        const val TIME_OUT_API: Long = 30
    }
}