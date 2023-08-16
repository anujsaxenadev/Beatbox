package com.wordpress.anujsaxenadev.beatbox.music_list.composables

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.wordpress.anujsaxenadev.beatbox.core.navigation.NavigationScreen

@Composable
fun MusicListScreen(navController: NavController) {
    Button(onClick = {
        navController.navigate(NavigationScreen.MusicPlayerScreen.route)
    }) {
        Text(text = "Navigate")
    }
}