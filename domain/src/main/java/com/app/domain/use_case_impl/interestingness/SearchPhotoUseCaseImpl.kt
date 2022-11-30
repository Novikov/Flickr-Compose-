package com.app.domain.use_case_impl.interestingness

import com.app.domain.models.interestingness.response.Photos
import com.app.domain.repository_api.PhotosRepository
import com.app.domain.use_case_api.interestingness.SearchPhotoUseCase

class SearchPhotoUseCaseImpl (val photosRepository: PhotosRepository) :
    SearchPhotoUseCase {
    override suspend fun invoke(query: String): Photos {
        return photosRepository.photosSearch(query = query)
    }
}
