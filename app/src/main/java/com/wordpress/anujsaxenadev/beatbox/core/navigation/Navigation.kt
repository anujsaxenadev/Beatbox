package com.wordpress.anujsaxenadev.beatbox.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.wordpress.anujsaxenadev.beatbox.music_list.composables.MusicListScreen
import com.wordpress.anujsaxenadev.beatbox.music_player.composables.MusicPlayerScreen

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.MusicListScreen.route) {
        composable(route = NavigationScreen.MusicListScreen.route) {
            MusicListScreen(navController = navController)
        }
        composable(route = NavigationScreen.MusicPlayerScreen.route) {
            MusicPlayerScreen(navController = navController)
        }
    }
}