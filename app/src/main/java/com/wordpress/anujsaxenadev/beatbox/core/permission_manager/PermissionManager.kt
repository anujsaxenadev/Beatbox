package com.wordpress.anujsaxenadev.beatbox.core.permission_manager

import androidx.compose.runtime.Composable
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.impl.PermissionInput

interface PermissionManager {
    @Composable
    fun checkPermission(permissionInput: PermissionInput)

    @Composable
    fun askPermission(permissionInput: PermissionInput)
}