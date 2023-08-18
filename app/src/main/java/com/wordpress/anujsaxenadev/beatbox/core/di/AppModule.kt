package com.wordpress.anujsaxenadev.beatbox.core.di

import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.PermissionManager
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.PermissionManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePermissionManager(): PermissionManager {
        return PermissionManagerImpl()
    }
}