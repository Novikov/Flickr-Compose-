package com.app.flickr2.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.flickr2.R
import com.app.flickr2.ui.Loader
import com.app.flickr2.ui.PhotoList
import com.app.flickr2.ui.theme.Flickr2Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun Search(
    modifier: Modifier = Modifier,
    toDetailButtonOnClick: () -> Unit,
    searchViewModel: SearchViewModel = koinViewModel()
) {
    Column {
        var query by rememberSaveable { mutableStateOf("") }
        SearchView(query = query, onQueryChanged = { query = it }, modifier = modifier)
        val viewState = searchViewModel.photosLiveData.observeAsState()
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            viewState.value?.let {
                PhotoList(
                    list = it,
                    modifier = modifier,
                    onItemClick = toDetailButtonOnClick
                )
            }
            Loader(modifier = modifier, isDisplayed = viewState.value.isNullOrEmpty())
        }
    }
}

@Composable
fun SearchView(query: String, onQueryChanged: (String) -> Unit, modifier: Modifier) {
    val colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Gray,
        textColor = Color.Black,
        cursorColor = Color.Black,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
        val painter = painterResource(id = R.drawable.ic_arrow_back)
        Icon(
            painter = painter,
            contentDescription = "Меню",
            modifier = modifier.padding(start = 16.dp),
            tint = Color.Black
        )
        TextField(
            value = query,
            onValueChange = onQueryChanged,
            singleLine = true,
            colors = colors,
            modifier = modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp).height(30.dp),
            shape = RoundedCornerShape(10.dp)
        )
    }
}

@Preview(name = "Featured Course")
@Composable
private fun FeaturedCoursePreview() {
    Flickr2Theme {
        Search(toDetailButtonOnClick = {})
    }
}
