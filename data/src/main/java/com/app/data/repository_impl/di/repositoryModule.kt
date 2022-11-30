package com.app.data.repository_impl.di

import com.app.data.repository_impl.InterestingnessRepositoryImpl
import com.app.data.repository_impl.PhotosRepositoryImpl
import com.app.domain.repository_api.InterestingnessRepository
import com.app.domain.repository_api.PhotosRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<InterestingnessRepository> {
        InterestingnessRepositoryImpl(interestingnessRemoteApiDataSource = get())
    }
    single<PhotosRepository> {
        PhotosRepositoryImpl(photosRemoteApiDataSource = get())
    }
}
