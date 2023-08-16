package com.wordpress.anujsaxenadev.beatbox.core.permission_manager

data class PermissionInput(val permission: String, val permissionListener: PermissionResult)

interface PermissionResult{
    fun onPermissionGranted()
    fun onPermissionDenied()
}