package com.wordpress.anujsaxenadev.beatbox.core.permission_manager.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.google.accompanist.permissions.*
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.PermissionManager

class PermissionManagerImpl : PermissionManager {
    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun checkPermission(
        permissionInput: PermissionInput
    ) {
        val permissionState = getPermissionState(permissionInput)
        if (permissionState.status.isGranted) {
            permissionInput.permissionListener.onPermissionGranted()
        } else if(permissionState.status.shouldShowRationale) {
            // Display a rationale for why the permission is needed
            permissionInput.permissionListener.onRationalRequired()
        }
        else {
            permissionInput.permissionListener.onPermissionRequired()
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    private fun getPermissionState(permissionInput: PermissionInput): PermissionState{
        return rememberPermissionState(permission = permissionInput.permission, onPermissionResult = {
                isGranted ->
            if(isGranted){
                permissionInput.permissionListener.onPermissionGranted()
            }
            else {
                permissionInput.permissionListener.onPermissionDenied()
            }
        })
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    override fun askPermission(permissionInput: PermissionInput){
        val permissionState = getPermissionState(permissionInput)
        LaunchedEffect("Permission_Request"){
            permissionState.launchPermissionRequest()
        }
    }
}
