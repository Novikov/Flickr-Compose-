package com.app.data.remote_data_source.network.providers

import com.app.data.remote_data_source.network.Endpoint
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    jsonConverterFactory: Converter.Factory,
    endpoint: Endpoint
): Retrofit = Retrofit.Builder()
    .baseUrl(endpoint.url.toURL())
    .client(okHttpClient)
    .addConverterFactory(jsonConverterFactory)
    .validateEagerly(true)
    .build()
