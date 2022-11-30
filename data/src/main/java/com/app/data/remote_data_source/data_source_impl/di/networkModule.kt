package com.app.data.remote_data_source.data_source_impl.di

import com.app.data.remote_data_source.network.Endpoints
import com.app.data.remote_data_source.network.providers.provideHttpLoggingInterceptor
import com.app.data.remote_data_source.network.providers.provideOkHttpProvider
import com.app.data.remote_data_source.network.providers.provideRetrofit
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { Endpoints.DEV }

    single<Converter.Factory> { MoshiConverterFactory.create(get()) }

    single {
        provideOkHttpProvider(httpLoggingInterceptor = get())
    }
    factory {
        provideRetrofit(
            okHttpClient = get(),
            jsonConverterFactory = get(),
            endpoint = get()
        )
    }

    single { provideHttpLoggingInterceptor() }
}
