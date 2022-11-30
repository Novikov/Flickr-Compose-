package com.app.domain.use_case_api.interestingness

import com.app.domain.models.interestingness.response.Photos

interface SearchPhotoUseCase {
    suspend fun invoke(query: String): Photos
}
