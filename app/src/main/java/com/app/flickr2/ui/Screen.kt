package com.app.flickr2.ui

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen")
    object SearchScreen : Screen("search_screen")
}
