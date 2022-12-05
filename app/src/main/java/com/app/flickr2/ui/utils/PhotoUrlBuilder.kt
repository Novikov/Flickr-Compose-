package com.app.flickr2.ui.utils

import com.app.data.remote_data_source.network.ApiConst
import com.app.data.remote_data_source.network.NetworkConst

object PhotoUrlBuilder {
    fun buildPhotoUrl(serverId: String, photoId: String, secret: String): String {
        return "${ApiConst.PHOTO_LOAD_BASE_URL}${serverId}${NetworkConst.SLASH}${photoId}${NetworkConst.UNDERSCORE}${secret}${NetworkConst.UNDERSCORE}$IMAGE_THUMBNAIL_SUFFIX$JPG_FORMAT"
    }
}
