package com.app.flickr2.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.flickr2.ui.detail.Detail
import com.app.flickr2.ui.home.Home
import com.app.flickr2.ui.login.Login
import com.app.flickr2.ui.search.Search

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            Login { navController.navigate(Screen.HomeScreen.route) }
        }
        composable(route = Screen.HomeScreen.route) {
            Home(onItemClick = { navController.navigate(Screen.DetailScreen.route) })
        }
        composable(route = Screen.DetailScreen.route) {
            Detail()
        }
        composable(route = Screen.SearchScreen.route) {
            Search(toDetailButtonOnClick = { navController.navigate(Screen.DetailScreen.route) })
        }
    }
}
