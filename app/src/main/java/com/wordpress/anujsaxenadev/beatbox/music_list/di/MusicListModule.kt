package com.wordpress.anujsaxenadev.beatbox.music_list.di

import com.wordpress.anujsaxenadev.beatbox.music_list.repository.MusicListRepository
import com.wordpress.anujsaxenadev.beatbox.music_list.repository.MusicListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MusicListModule {
    @Provides
    @Singleton
    fun provideMusicListRepository(): MusicListRepository{
        return MusicListRepositoryImpl()
    }
}