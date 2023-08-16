package com.wordpress.anujsaxenadev.beatbox.core.navigation

sealed class NavigationScreen(val route: String){
    object MusicListScreen: NavigationScreen("music_list_screen")
    object MusicPlayerScreen: NavigationScreen("music_player_screen")
}
