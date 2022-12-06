package com.app.flickr2.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import com.app.flickr2.ui.home.mapper.PhotosUIMapper
import com.app.flickr2.ui.home.model.PhotoDataUI
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getMostInterestingPhotosUseCase: GetMostInterestingPhotosUseCase,
    private val photosUIMapper: PhotosUIMapper
) :
    ViewModel() {

    private val photosMutableLiveData = MutableLiveData<List<PhotoDataUI>>()
    val photosLiveData: LiveData<List<PhotoDataUI>>
        get() = photosMutableLiveData

    init {
        getMostInterestingPhotoList()
    }

    // TODO: Implement logging + use (now it throws exception)
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("NetworkError", "Network error")
    }

    private fun getMostInterestingPhotoList() {
        viewModelScope.launch {
            runCatching {
                val photoList = async { getMostInterestingPhotosUseCase.invoke() }.await()
                photoList.photo.map { photosUIMapper.toPhotoDataUI(it) }
            }
                .onSuccess { photosMutableLiveData.postValue(it) }
                .onFailure {
                    Log.e("NetworkError", "Network error $it")
                }
        } // todo think about onFailure.
    }
}
