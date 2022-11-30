package com.app.domain.use_case_impl.interestingness

import com.app.domain.models.interestingness.response.Photos
import com.app.domain.repository_api.InterestingnessRepository
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase

class GetMostInterestingPhotosUseCaseImpl(val interestingnessRepository: InterestingnessRepository) :
    GetMostInterestingPhotosUseCase {
    override suspend fun invoke(): Photos {
        return interestingnessRepository.getPhotoList()
    }
}
