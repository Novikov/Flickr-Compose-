package com.app.data.remote_data_source.data_source_impl.photos

import com.app.data.remote_data_source.data_source_api.PhotosRemoteApiDataSource
import com.app.data.remote_data_source.data_source_impl.interestingness.InterestingnessMapper
import com.app.domain.models.interestingness.response.Photos

class PhotosRemoteApiDataSourceImpl(
    val photosApiService: PhotosApiService,
    val interestingnessMapper: InterestingnessMapper
) : PhotosRemoteApiDataSource {
    override suspend fun photosSearch(query: String): Photos {
        val response = photosApiService.getPhotoSearch(query = query)
        return interestingnessMapper.toPhotos(response.photos)
    }
}
