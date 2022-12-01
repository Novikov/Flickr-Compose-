package com.app.flickr2.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.flickr2.ui.theme.Flickr2Theme

@Composable
fun Home(modifier: Modifier = Modifier, loginOnClick: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home screen")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { loginOnClick.invoke() }
        ) {
            Text(text = "to Detail")
        }
    }
}

@Preview(name = "Featured Course")
@Composable
private fun FeaturedCoursePreview() {
    Flickr2Theme {
        Home() {}
    }
}
