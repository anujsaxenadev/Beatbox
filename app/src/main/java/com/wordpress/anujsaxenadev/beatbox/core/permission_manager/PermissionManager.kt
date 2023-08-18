package com.wordpress.anujsaxenadev.beatbox.core.permission_manager

import androidx.compose.runtime.Composable

interface PermissionManager {
    @Composable
    fun checkPermission(permissionInput: PermissionInput)
}