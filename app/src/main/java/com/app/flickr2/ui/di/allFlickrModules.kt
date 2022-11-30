package com.app.flickr2.ui.di

import com.app.data.local_data_source.di.localDataSourceModule
import com.app.data.remote_data_source.data_source_impl.di.networkModule
import com.app.data.remote_data_source.data_source_impl.di.remoteDataSourceModule
import com.app.data.repository_impl.di.repositoryModule
import com.app.domain.di.domainModule
import com.app.flickr2.ui.home.di.homeModule
import com.app.flickr2.ui.login.di.loginModule

val allFlickrModules = loginModule +
    homeModule +
    repositoryModule +
    remoteDataSourceModule +
    localDataSourceModule +
    networkModule +
    domainModule
