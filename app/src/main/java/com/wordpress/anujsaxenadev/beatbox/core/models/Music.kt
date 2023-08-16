package com.wordpress.anujsaxenadev.beatbox.core.models

data class Music(
    val id: String,
    val path: String,
    val title: String,
    val album: String,
    val artist: String,
    val duration: Long = 0)