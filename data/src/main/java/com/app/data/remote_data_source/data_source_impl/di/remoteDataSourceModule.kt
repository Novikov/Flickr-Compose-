package com.app.data.remote_data_source.data_source_impl.di

import com.app.data.remote_data_source.data_source_impl.interestingness.di.interestingnessModule
import com.app.data.remote_data_source.data_source_impl.photos.di.photosModule

val remoteDataSourceModule = interestingnessModule + photosModule
