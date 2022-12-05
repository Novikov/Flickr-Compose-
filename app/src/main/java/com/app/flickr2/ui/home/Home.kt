package com.app.flickr2.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.flickr2.ui.home.model.PhotoDataUI
import com.app.flickr2.ui.theme.Flickr2Theme
import com.app.flickr2.ui.utils.PhotoUrlBuilder
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinViewModel()
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        val viewState = homeViewModel.photosLiveData.observeAsState()
        viewState.value?.let { PhotoList(list = it) }
    }
}

@Composable
fun PhotoList(list: List<PhotoDataUI>) { // todo think about keys
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(items = list, key = { photo -> photo.photoId }) { photo ->
            PhotoItem(photoDataUI = photo)
        }
    }
}

@Composable
fun PhotoItem(photoDataUI: PhotoDataUI) {
    val photoUrl = PhotoUrlBuilder.buildPhotoUrl(
        photoDataUI.serverId,
        photoDataUI.photoId,
        photoDataUI.secret
    )
    AsyncImage(
        model = photoUrl,
        contentDescription = "",
        modifier = Modifier.sizeIn(minHeight = 140.dp, minWidth = 140.dp)
    )
} // todo implement onclick

@Preview(name = "Featured Course")
@Composable
private fun FeaturedCoursePreview() {
    Flickr2Theme {
        Home()
    }
}
