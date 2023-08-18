package com.wordpress.anujsaxenadev.beatbox.music_list.view_models

import androidx.lifecycle.ViewModel
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.PermissionManager
import com.wordpress.anujsaxenadev.beatbox.music_list.repository.MusicListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MusicListViewModel @Inject constructor(
    private val repository: MusicListRepository,
    private val permissionManager: PermissionManager
) : ViewModel(){

}