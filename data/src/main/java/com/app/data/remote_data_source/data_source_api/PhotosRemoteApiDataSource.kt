package com.app.data.remote_data_source.data_source_api

import com.app.domain.models.interestingness.response.Photos

interface PhotosRemoteApiDataSource {
    suspend fun photosSearch(query: String): Photos
}
