package com.wordpress.anujsaxenadev.beatbox.music_list.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.wordpress.anujsaxenadev.beatbox.core.models.Music

@Composable
fun musicListComposable(musicList: List<Music>) {
    LazyColumn {
        items(musicList.size) { index ->
            Text(text = musicList[index].title)
        }
    }
}