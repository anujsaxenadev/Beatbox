package com.wordpress.anujsaxenadev.beatbox.core.components.implementations

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun LocalImageView(resourceId: Int){
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = ""
    )
}