package com.app.flickr2.ui.home.di

import com.app.flickr2.ui.home.HomeViewModel
import com.app.flickr2.ui.home.mapper.PhotosUIMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single<PhotosUIMapper> { PhotosUIMapper() }
    viewModel { HomeViewModel(getMostInterestingPhotosUseCase = get(), photosUIMapper = get()) }
}
