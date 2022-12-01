package com.app.flickr2.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.flickr2.ui.home.Home
import com.app.flickr2.ui.login.Login

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            Login { navController.navigate(Screen.HomeScreen.route) }
        }
        composable(route = Screen.HomeScreen.route) {
            Home { navController.navigate(Screen.DetailScreen.route) }
        }
    }
}
