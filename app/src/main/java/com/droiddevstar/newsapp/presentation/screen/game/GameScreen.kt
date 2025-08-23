package com.droiddevstar.newsapp.presentation.screen.game

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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.droiddevstar.newsapp.presentation.ui.component.StyledButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GameScreen() {
    val screenData: MutableState<ScreenData> = remember {
        mutableStateOf(ScreenData())
    }

    MeasureSizes(
        onMeasureDone = {
            screenData.value = it
        }
    )

    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    val offsetXPx: Animatable<Float, AnimationVector1D> = remember {
        Animatable(0f)
    }

    val offsetYPx: Animatable<Float, AnimationVector1D> = remember {
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
                .offset {
                    IntOffset(
                        x = offsetXPx.value.toInt(),
                        y = offsetYPx.value.toInt()
                    )
                }
                .size(50.dp)
                .background(color = MaterialTheme.colorScheme.onBackground)
        )

        GameButtons(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter),
            screenData = screenData.value,
            offsetXPx = offsetXPx,
            offsetYPx = offsetYPx
        )
    }
}

@Composable
@Preview
fun GameScreenPreview() {
    GameScreen()
}

const val SQUARE_SIZE_DP = 50
const val PADDING_HORIZONTAL_DP = 20