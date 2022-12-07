package com.app.flickr2.ui.utils.ext

import android.util.Log
import com.app.flickr2.ui.utils.DEFAULT_ERROR_TAG
import com.app.flickr2.ui.utils.DEFAULT_TAG
import org.koin.androidx.compose.BuildConfig

fun logIfDebug(message: String?, log: String = DEFAULT_TAG) {
    if (BuildConfig.DEBUG) {
        Log.i(log, message.orEmpty())
    }
}

fun logErrorIfDebug(throwable: Throwable, tag: String = DEFAULT_ERROR_TAG) {
    throwable.printStackTrace()
} // TODO: Think how to fix build config detecting
