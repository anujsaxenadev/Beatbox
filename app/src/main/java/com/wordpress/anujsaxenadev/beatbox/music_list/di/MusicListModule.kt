package com.wordpress.anujsaxenadev.beatbox.music_list.di

import android.content.Context
import com.wordpress.anujsaxenadev.beatbox.music_list.repository.MusicListRepository
import com.wordpress.anujsaxenadev.beatbox.music_list.repository.MusicListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MusicListModule {
    @Provides
    @Singleton
    fun provideMusicListRepository(@ApplicationContext context: Context): MusicListRepository{
        return MusicListRepositoryImpl(context)
    }
}