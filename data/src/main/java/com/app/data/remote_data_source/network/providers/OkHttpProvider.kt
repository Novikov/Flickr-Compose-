package com.app.data.remote_data_source.network.providers

import com.app.data.BuildConfig
import com.app.data.remote_data_source.network.NetworkConst.TIMEOUT_TIME_IN_SECOND
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

fun provideOkHttpProvider(
    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient = OkHttpClient.Builder()
    .readTimeout(TIMEOUT_TIME_IN_SECOND, TimeUnit.SECONDS)
    .connectTimeout(TIMEOUT_TIME_IN_SECOND, TimeUnit.SECONDS)
    .addInterceptor(httpLoggingInterceptor)
    .build()

// TODO Improve error logging

fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level =
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    return httpLoggingInterceptor
}
