package com.app.flickr2.ui.home.mapper

import com.app.domain.models.interestingness.response.Photo
import com.app.flickr2.ui.home.model.PhotoDataUI
import com.app.flickr2.ui.utils.IMAGE_THUMBNAIL_SUFFIX

class PhotosUIMapper {

    fun toPhotoDataUI(photoResponse: Photo): PhotoDataUI = with(photoResponse) {
        return PhotoDataUI(
            photoId = id,
            serverId = server,
            secret = secret,
            size = IMAGE_THUMBNAIL_SUFFIX
        )
    }
}
