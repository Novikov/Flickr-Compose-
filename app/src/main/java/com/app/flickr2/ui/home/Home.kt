package com.app.flickr2.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
    homeViewModel: HomeViewModel = koinViewModel(),
    onItemClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize().padding(0.5.dp)
    ) {
        val viewState = homeViewModel.photosLiveData.observeAsState()
        viewState.value?.let {
            PhotoList(
                list = it,
                modifier = modifier,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
fun PhotoList(
    list: List<PhotoDataUI>,
    modifier: Modifier,
    onItemClick: () -> Unit = {}
) { // todo think about keys
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        items(items = list, key = { photo -> photo.photoId }) { photo ->
            Surface(
                modifier = Modifier.clickable {
                    onItemClick.invoke()
                }.padding(1.dp)
            ) {
                PhotoItem(photoDataUI = photo, modifier = modifier)
            }
        }
    }
}

@Composable
fun PhotoItem(photoDataUI: PhotoDataUI, modifier: Modifier) {
    val photoUrl = PhotoUrlBuilder.buildPhotoUrl(
        photoDataUI.serverId,
        photoDataUI.photoId,
        photoDataUI.secret
    )
    AsyncImage(
        model = photoUrl,
        contentDescription = "",
        modifier = modifier.sizeIn(minHeight = 140.dp, minWidth = 140.dp),
        contentScale = ContentScale.Crop
    )
}

@Preview(name = "Featured Course")
@Composable
private fun FeaturedCoursePreview() {
    Flickr2Theme {
        Home(onItemClick = {})
    }
}
