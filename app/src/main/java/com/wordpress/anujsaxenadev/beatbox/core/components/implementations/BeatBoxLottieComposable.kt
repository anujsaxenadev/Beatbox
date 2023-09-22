package com.wordpress.anujsaxenadev.beatbox.core.components.implementations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun BeatBoxLottieComposable(resourceId: Int) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(resourceId))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}

