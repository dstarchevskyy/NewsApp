package com.droiddevstar.newsapp.presentation.screen.game

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MeasureSizes(
    onMeasureDone: (ScreenData) -> Unit
) {
    val configuration: Configuration = LocalConfiguration.current
    val density: Density = LocalDensity.current

    LaunchedEffect(key1 = configuration) {
        val screenWidth: Dp = configuration.screenWidthDp.dp
        val screenHeight: Dp = configuration.screenHeightDp.dp

        val screenWidthPx: Float = with(density) { screenWidth.toPx() }
        val screenHeightPx: Float = with(density) { screenHeight.toPx() }
        val squareSizePx: Float = with(density) { SQUARE_SIZE_DP.dp.toPx()}
        val horizontalPaddingPx: Float = with(density) { PADDING_HORIZONTAL_DP.dp.toPx()}

        onMeasureDone(
            ScreenData(
                widthPx = screenWidthPx,
                heightPx = screenHeightPx,
                squareSizePx = squareSizePx,
                horizontalPaddingPx = horizontalPaddingPx
            )
        )
    }
}