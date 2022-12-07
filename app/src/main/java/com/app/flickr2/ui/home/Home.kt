package com.app.flickr2.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.app.flickr2.R
import com.app.flickr2.ui.home.model.PhotoDataUI
import com.app.flickr2.ui.theme.Flickr2Theme
import com.app.flickr2.ui.utils.PhotoUrlBuilder
import org.koin.androidx.compose.koinViewModel

@Composable
fun Home(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = koinViewModel(),
    onItemClick: () -> Unit,
    onSearchIconClick: () -> Unit,
    onSavedIconClick: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.White) {
            IconButton(onClick = { }) {
                val painter = painterResource(id = R.drawable.ic_burger_button)
                Icon(
                    painter = painter,
                    contentDescription = "Меню",
                    modifier = modifier,
                    tint = Color.Black
                )
            }
            Text(
                "Flickr",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(Modifier.weight(1f, true))
            IconButton(onClick = onSearchIconClick) {
                val painter = painterResource(id = R.drawable.ic_search)
                Icon(
                    painter = painter,
                    contentDescription = "Поиск",
                    modifier = modifier,
                    tint = Color.Black
                )
            }
            IconButton(onClick = onSavedIconClick) {
                val painter = painterResource(id = R.drawable.ic_save)
                Icon(
                    painter = painter,
                    contentDescription = "Сохранить",
                    modifier = modifier,
                    tint = Color.Black
                )
            }
        }
    }) {
        val viewState = homeViewModel.photosLiveData.observeAsState()
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            viewState.value?.let {
                PhotoList(
                    list = it,
                    modifier = modifier,
                    onItemClick = onItemClick
                )
            }
            Loader(modifier = modifier, isDisplayed = viewState.value.isNullOrEmpty())
        }
    }
}

// TODO: Align menu button and app name

// TODO: change dp to grids in all app

@Composable
fun Loader(modifier: Modifier, isDisplayed: Boolean) {
    if (isDisplayed) {
        CircularProgressIndicator(
            modifier = modifier.size(90.dp),
            color = Color.Black,
            strokeWidth = 6.dp
        )
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
                modifier = Modifier
                    .clickable {
                        onItemClick.invoke()
                    }
                    .padding(1.dp)
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
        CircularProgressIndicator(
            modifier = Modifier.size(100.dp),
            color = Color.Green,
            strokeWidth = 10.dp
        )
    }
}
