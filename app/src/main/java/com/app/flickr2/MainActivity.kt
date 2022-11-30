package com.app.flickr2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.app.domain.use_case_api.interestingness.GetMostInterestingPhotosUseCase
import com.app.flickr2.ui.theme.Flickr2Theme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    val getMostInterestingPhotosUseCase by inject<GetMostInterestingPhotosUseCase>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("SDASDASD", "$getMostInterestingPhotosUseCase")
        setContent {
            Flickr2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Flickr2Theme {
        Greeting("Android")
    }
}
