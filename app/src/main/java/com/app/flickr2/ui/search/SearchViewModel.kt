package com.app.flickr2.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.domain.use_case_api.interestingness.SearchPhotoUseCase
import com.app.flickr2.ui.home.model.PhotoDataUI
import com.app.flickr2.ui.search.mapper.PhotoSearchUIMapper

class SearchViewModel(
    private val searchPhotoUseCase: SearchPhotoUseCase,
    private val photosSearchUIMapper: PhotoSearchUIMapper
) : ViewModel() {
    private val photosMutableLiveData = MutableLiveData<List<PhotoDataUI>>()
    val photosLiveData: LiveData<List<PhotoDataUI>>
        get() = photosMutableLiveData
}
