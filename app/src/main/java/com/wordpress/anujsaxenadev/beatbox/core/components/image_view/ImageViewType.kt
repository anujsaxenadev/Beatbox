package com.wordpress.anujsaxenadev.beatbox.core.components.image_view

sealed class ImageViewType{
    object JsonAnimation : ImageViewType()
    object LocalImage : ImageViewType()
}