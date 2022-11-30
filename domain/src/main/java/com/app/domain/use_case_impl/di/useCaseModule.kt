package com.app.domain.use_case_impl.di

import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import com.app.domain.use_case_api.interestingness.SearchPhotoUseCase
import com.app.domain.use_case_impl.interestingness.GetMostInterestingPhotosUseCaseImpl
import com.app.domain.use_case_impl.interestingness.SearchPhotoUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetMostInterestingPhotosUseCase> {
        GetMostInterestingPhotosUseCaseImpl(
            interestingnessRepository = get()
        )
    }
    single<SearchPhotoUseCase> { SearchPhotoUseCaseImpl(photosRepository = get()) }
}
