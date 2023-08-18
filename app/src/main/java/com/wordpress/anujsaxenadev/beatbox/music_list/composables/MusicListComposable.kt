package com.wordpress.anujsaxenadev.beatbox.music_list.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.wordpress.anujsaxenadev.beatbox.music_list.repository.MusicListRepository

@Composable
fun musicListComposable() {
    val context = LocalContext.current
    LazyColumn {
//        val musicList = MusicListRepository().getLocalAudioFiles(context)
//        items(musicList.musicList.size) { index ->
//            Text(text = musicList.musicList[index].title)
//        }
    }
}