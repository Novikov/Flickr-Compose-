package com.app.data.remote_data_source.data_source_impl.photos.di

import com.app.data.remote_data_source.data_source_api.InterestingnessRemoteApiDataSource
import com.app.data.remote_data_source.data_source_api.PhotosRemoteApiDataSource
import com.app.data.remote_data_source.data_source_impl.interestingness.InterestingnessRemoteApiDataSourceImp
import com.app.data.remote_data_source.data_source_impl.photos.PhotosApiService
import com.app.data.remote_data_source.data_source_impl.photos.PhotosRemoteApiDataSourceImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val photosModule = module {
    single<PhotosApiService> { get<Retrofit>().create(PhotosApiService::class.java) }
//    single { InterestingnessMapper() } TODO think how to move it to common
    single<PhotosRemoteApiDataSource> {
        PhotosRemoteApiDataSourceImpl(
            photosApiService = get(),
            interestingnessMapper = get()
        )
    }
}
