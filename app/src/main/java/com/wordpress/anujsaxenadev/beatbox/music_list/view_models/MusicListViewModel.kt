package com.wordpress.anujsaxenadev.beatbox.music_list.view_models

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.wordpress.anujsaxenadev.beatbox.core.models.Music
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.PermissionManager
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.impl.PermissionInput
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.impl.PermissionResult
import com.wordpress.anujsaxenadev.beatbox.music_list.repository.MusicListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MusicListViewModel @Inject constructor(
    private val repository: MusicListRepository,
    private val permissionManager: PermissionManager
) : ViewModel(){
    private val _musicListState = MutableStateFlow<List<Music>>(ArrayList())
    val musicListState = _musicListState.asStateFlow()

    fun getAllAudioFiles(){
        repository.getLocalAudioFiles {
            _musicListState.value = it.musicList
        }
    }
    @Composable
    fun requestWriteStoragePermission(){
        permissionManager.askPermission(PermissionInput(Manifest.permission.WRITE_EXTERNAL_STORAGE, object: PermissionResult {
            override fun onPermissionGranted() {
                getAllAudioFiles()
            }

            override fun onPermissionDenied() {

            }

            @Composable
            override fun onRationalRequired() {

            }

            @Composable
            override fun onPermissionRequired() {

            }
        }))
    }

    @Composable
    fun initLocalStoragePermissionFlow(){
        permissionManager.checkPermission(PermissionInput(Manifest.permission.WRITE_EXTERNAL_STORAGE, object: PermissionResult {
            override fun onPermissionGranted() {
                getAllAudioFiles()
            }

            override fun onPermissionDenied() {

            }

            @Composable
            override fun onRationalRequired() {
                requestWriteStoragePermission()
            }
            @Composable
            override fun onPermissionRequired() {
                requestWriteStoragePermission()
            }
        }))
    }
}