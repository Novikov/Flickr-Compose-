package com.app.domain.repository_api

import com.app.domain.models.interestingness.response.Photos

interface PhotosRepository {
    suspend fun photosSearch(query: String): Photos
}
