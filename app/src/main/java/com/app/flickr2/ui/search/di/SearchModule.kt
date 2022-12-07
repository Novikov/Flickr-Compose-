package com.app.flickr2.ui.search.di

import com.app.flickr2.ui.search.SearchViewModel
import com.app.flickr2.ui.search.mapper.PhotoSearchUIMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    single<PhotoSearchUIMapper> { PhotoSearchUIMapper() }
    viewModel { SearchViewModel(photosSearchUIMapper = get(), searchPhotoUseCase = get()) }
}
