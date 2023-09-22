package com.wordpress.anujsaxenadev.beatbox.music_list.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.wordpress.anujsaxenadev.beatbox.R
import com.wordpress.anujsaxenadev.beatbox.core.components.ImageView
import com.wordpress.anujsaxenadev.beatbox.core.components.image_view.ImagePayload
import com.wordpress.anujsaxenadev.beatbox.core.components.image_view.ImageViewType
import com.wordpress.anujsaxenadev.beatbox.music_list.view_models.MusicListViewModel

@ExperimentalPermissionsApi
@Composable
fun MusicListScreen(navController: NavController) {
    val musicListViewModel: MusicListViewModel = hiltViewModel()

    musicListViewModel.initLocalStoragePermissionFlow()
    val musicList = musicListViewModel.musicListState.collectAsState().value
    if(musicList.isEmpty()){
        ImageView(ImagePayload(ImageViewType.JsonAnimation, R.raw.empty))
    }
    else{
        musicListComposable(musicListViewModel.musicListState.collectAsState().value)
    }
}