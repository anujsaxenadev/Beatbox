package com.wordpress.anujsaxenadev.beatbox.music_list.composables

import android.Manifest
import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.wordpress.anujsaxenadev.beatbox.core.navigation.NavigationScreen
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.PermissionInput
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.PermissionManager
import com.wordpress.anujsaxenadev.beatbox.core.permission_manager.PermissionResult

@ExperimentalPermissionsApi
@Composable
fun MusicListScreen(navController: NavController) {
    val context = LocalContext.current
    PermissionManager().checkPermission(PermissionInput(Manifest.permission.WRITE_EXTERNAL_STORAGE, object: PermissionResult{
        override fun onPermissionGranted() {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_LONG).show()
        }

        override fun onPermissionDenied() {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_LONG).show()
        }
    }))
    Button(onClick = {
        navController.navigate(NavigationScreen.MusicPlayerScreen.route)
    }) {
        Text(text = "Navigate")
    }
}