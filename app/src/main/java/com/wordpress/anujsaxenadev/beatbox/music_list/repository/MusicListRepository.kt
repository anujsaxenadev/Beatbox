package com.wordpress.anujsaxenadev.beatbox.music_list.repository

import android.content.Context
import com.wordpress.anujsaxenadev.beatbox.music_list.models.MusicList

interface MusicListRepository {
    fun getLocalAudioFiles(callback: (MusicList) -> Unit)
}