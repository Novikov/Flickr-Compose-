package com.app.flickr2.ui.home.model

import com.app.flickr2.ui.base.UIContent

data class PhotoDataUI(
    val photoId: String,
    val serverId: String,
    val secret: String,
    val size: String
) : UIContent
