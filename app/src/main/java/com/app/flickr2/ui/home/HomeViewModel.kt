package com.app.flickr2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import com.app.flickr2.ui.home.mapper.PhotosUIMapper
import com.app.flickr2.ui.home.model.PhotoDataUI
import com.app.flickr2.ui.utils.ext.logErrorIfDebug
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

    private fun getMostInterestingPhotoList() {
        viewModelScope.launch {
            runCatching {
                getMostInterestingPhotosUseCase.invoke()
            }
                .onSuccess { photos ->
                    val photoList = photos.photo.map { photosUIMapper.toPhotoDataUI(it) }
                    photosMutableLiveData.postValue(photoList)
                }
                .onFailure {
                    logErrorIfDebug(it)
                }
        }
    }
}
