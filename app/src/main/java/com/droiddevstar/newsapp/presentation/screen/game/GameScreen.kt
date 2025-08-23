package com.droiddevstar.newsapp.presentation.screen.game

import android.content.res.Configuration
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droiddevstar.newsapp.presentation.ui.component.StyledButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GameScreen() {
    val screenSize: ScreenSize = rememberScreenSize()

    println("@@@screenSize: ${screenSize}")

    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    val offsetX: Animatable<Float, AnimationVector1D> = remember {
        Animatable(0f)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .padding(
                vertical = 28.dp,
                horizontal = PADDING_HORIZONTAL_DP.dp
                )
                .offset(
                    x = offsetX.value.dp,
                    y = 0.dp
                )
                .size(50.dp)
                .background(color = MaterialTheme.colorScheme.onBackground)
        )

        Row(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
        ) {
            StyledButton(
                modifier = Modifier
                    .padding(bottom = SQUARE_SIZE_DP.dp),
                onClick = {
                    coroutineScope.launch {
                        offsetX.animateTo(
                            targetValue = 0f,
                            animationSpec = TweenSpec(),
                        )
                    }
                }
            ) {
                Text(text = "Left")
            }

            StyledButton(
                modifier = Modifier
                    .padding(bottom = SQUARE_SIZE_DP.dp),
                onClick = {
                    coroutineScope.launch {
                        offsetX.animateTo(
                            targetValue = screenSize.widthDp.value - SQUARE_SIZE_DP - (PADDING_HORIZONTAL_DP * 2),
                            animationSpec = TweenSpec(),
                        )
                    }
                }
            ) {
                Text(text = "Right")
            }

        }
    }
}

@Composable
fun rememberScreenSize(): ScreenSize {
    val configuration: Configuration = LocalConfiguration.current

    return remember(configuration) {
        ScreenSize(
            widthDp = configuration.screenWidthDp.dp,
            heightDp = configuration.screenHeightDp.dp
        )
    }
}

@Composable
@Preview
fun GameScreenPreview() {
    GameScreen()
}

private const val SQUARE_SIZE_DP = 50
private const val PADDING_HORIZONTAL_DP = 20