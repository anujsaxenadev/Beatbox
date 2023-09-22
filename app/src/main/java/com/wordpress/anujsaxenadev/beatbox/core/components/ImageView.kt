package com.wordpress.anujsaxenadev.beatbox.core.components

import androidx.compose.runtime.Composable
import com.wordpress.anujsaxenadev.beatbox.core.components.image_view.ImagePayload
import com.wordpress.anujsaxenadev.beatbox.core.components.image_view.ImageViewType
import com.wordpress.anujsaxenadev.beatbox.core.components.implementations.BeatBoxLottieComposable
import com.wordpress.anujsaxenadev.beatbox.core.components.implementations.LocalImageView

@Composable
fun ImageView(payload: ImagePayload){
    when(payload.type){
        ImageViewType.LocalImage -> {
            LocalImageView(payload.resourceId)
        }
        ImageViewType.JsonAnimation -> {
            BeatBoxLottieComposable(payload.resourceId)
        }
    }
}