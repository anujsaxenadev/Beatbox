package com.wordpress.anujsaxenadev.beatbox.core.permission_manager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.google.accompanist.permissions.*

class PermissionManager {
    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun checkPermission(
        permissionInput: PermissionInput
    ) {
        val permissionState = rememberPermissionState(permission = permissionInput.permission, onPermissionResult = {
                isGranted ->
            if(isGranted){
                permissionInput.permissionListener.onPermissionGranted()
            }
            else {
                permissionInput.permissionListener.onPermissionDenied()
            }
        })
        if (permissionState.status.isGranted) {
            permissionInput.permissionListener.onPermissionGranted()
        } else if(permissionState.status.shouldShowRationale) {
            // Display a rationale for why the permission is needed
            askPermission(permissionState = permissionState)
        }
        else {
            askPermission(permissionState = permissionState)
        }
    }

    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun askPermission(permissionState: PermissionState){
        LaunchedEffect("Permission_Request"){
            permissionState.launchPermissionRequest()
        }
    }
}
