package com.app.data.remote_data_source.data_source_impl.interestingness.di

import com.app.data.remote_data_source.data_source_api.InterestingnessRemoteApiDataSource
import com.app.data.remote_data_source.data_source_impl.interestingness.InterestingnessApiService
import com.app.data.remote_data_source.data_source_impl.interestingness.InterestingnessMapper
import com.app.data.remote_data_source.data_source_impl.interestingness.InterestingnessRemoteApiDataSourceImp
import org.koin.dsl.module
import retrofit2.Retrofit

val interestingnessModule = module {
    single<InterestingnessApiService> { get<Retrofit>().create(InterestingnessApiService::class.java) }
    single { InterestingnessMapper() }
    single<InterestingnessRemoteApiDataSource> {
        InterestingnessRemoteApiDataSourceImp(
            interestingnessApiService = get(),
            interestingnessMapper = get()
        )
    }
}
