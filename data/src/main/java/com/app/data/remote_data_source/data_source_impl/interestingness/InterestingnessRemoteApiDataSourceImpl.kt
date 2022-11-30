package com.app.data.remote_data_source.data_source_impl.interestingness

import com.app.data.remote_data_source.data_source_api.InterestingnessRemoteApiDataSource
import com.app.domain.models.interestingness.response.Photos

class InterestingnessRemoteApiDataSourceImp(
    val interestingnessApiService: InterestingnessApiService,
    val interestingnessMapper: InterestingnessMapper
) : InterestingnessRemoteApiDataSource {

    override suspend fun getPhotoList(): Photos {
        val response = interestingnessApiService.getInterestingnessPhotos()
        return interestingnessMapper.toPhotos(response.photos)
    }
}
