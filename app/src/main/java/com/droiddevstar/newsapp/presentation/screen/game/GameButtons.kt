package com.droiddevstar.newsapp.presentation.screen.game

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.droiddevstar.newsapp.presentation.ui.component.StyledButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun GameButtons(
    modifier: Modifier,
    screenData: ScreenData,
    offsetXPx: Animatable<Float, AnimationVector1D>,
    offsetYPx: Animatable<Float, AnimationVector1D>
) {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Row(
        modifier = modifier
    ) {
        StyledButton(
            modifier = Modifier
                .padding(bottom = SQUARE_SIZE_DP.dp),
            onClick = {
                coroutineScope.launch {
                    offsetXPx.animateTo(
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
                    offsetXPx.animateTo(
                        targetValue = screenData.widthPx - screenData.squareSizePx - screenData.horizontalPaddingPx * 2,
                        animationSpec = TweenSpec(),
                    )
                }
            }
        ) {
            Text(text = "Right")
        }

    }
}