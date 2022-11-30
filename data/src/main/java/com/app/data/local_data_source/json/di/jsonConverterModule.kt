package com.app.data.local_data_source.json.di

import com.app.data.local_data_source.json.JsonConverter
import com.app.data.local_data_source.json.MoshiJsonConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.dsl.module

val jsonConverterModule = module {
    single {
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }
    single<JsonConverter> { MoshiJsonConverter(moshi = get()) }
}
