package com.wordpress.anujsaxenadev.beatbox.music_list.repository

import android.content.Context
import android.provider.MediaStore
import android.util.Log
import com.wordpress.anujsaxenadev.beatbox.core.models.Music
import com.wordpress.anujsaxenadev.beatbox.music_list.models.MusicList
import kotlinx.coroutines.*
import javax.inject.Inject

class MusicListRepositoryImpl @Inject constructor() : MusicListRepository{
    override suspend fun getLocalAudioFiles(context: Context, callback: (MusicList) -> Unit) {
        val exceptionHandler =  CoroutineExceptionHandler{ _, e ->
            Log.e("anuj-log", e.toString())
        }
        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO + exceptionHandler) {
            val musicList = MusicList()
            val contentResolver = context.contentResolver
            val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"
            val projection = arrayOf(
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATE_ADDED,
                MediaStore.Audio.Media.DATA
            )
            val cursor = contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                MediaStore.Audio.Media.DATE_ADDED + " DESC",
                null
            )
            if(cursor != null){
                if(cursor.moveToFirst()){
                    do {
                        val idIndex = cursor.getColumnIndex(MediaStore.Audio.Media._ID)
                        val titleIndex = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
                        val albumIndex = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)
                        val artistIndex = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)
                        val durationIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)
                        val dataIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DATA)
                        if(
                            idIndex != -1
                            && titleIndex != -1
                            && albumIndex != -1
                            && artistIndex != -1
                            && durationIndex != -1
                            && dataIndex != -1){
                            musicList.musicList.add(
                                Music(
                                    cursor.getString(idIndex),
                                    cursor.getString(dataIndex),
                                    cursor.getString(titleIndex),
                                    cursor.getString(albumIndex),
                                    cursor.getString(artistIndex),
                                    cursor.getLong(durationIndex),
                                )
                            )
                        }
                    }
                    while(cursor.moveToNext())
                    cursor.close()
                }
            }
            withContext(Dispatchers.Main) {
                callback (musicList)
            }
        }
    }
}