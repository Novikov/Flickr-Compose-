package com.app.data.repository_impl

import com.app.data.remote_data_source.data_source_api.PhotosRemoteApiDataSource
import com.app.domain.models.interestingness.response.Photos
import com.app.domain.repository_api.PhotosRepository

class PhotosRepositoryImpl(private val photosRemoteApiDataSource: PhotosRemoteApiDataSource) :
    PhotosRepository {
    override suspend fun photosSearch(query: String): Photos {
        return photosRemoteApiDataSource.photosSearch(query = query)
    }
}
