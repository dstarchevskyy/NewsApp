package com.droiddevstar.newsapp.presentation.screen.about

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EyeView(
    modifier: Modifier = Modifier,
    side: Side? = null
) {
    Box(modifier = modifier,
        contentAlignment = Alignment.BottomEnd) {
        Box(modifier = Modifier.size(10.dp, 5.dp),
            contentAlignment = when(side) {
                Side.LEFT_SIDE -> Alignment.CenterStart
                Side.RIGHT_SIDE -> Alignment.CenterEnd
                else -> Alignment.Center
            }
        ) {

                    Canvas(
                        modifier = Modifier.size(10.dp, 5.dp)

                    ) {
                        // Draw filled white oval
                        drawOval(
                            color = Color.White,
                            size = size
                        )

                        // Draw black outline
                        drawOval(
                            color = Color.Black,
                            size = size,
                            style = Stroke(width = 1.dp.toPx())
                        )
                    }

                    Canvas(
                        modifier = Modifier.size(3.dp, 3.dp)
                    ) {
                        // Draw filled white oval
                        drawOval(
                            color = Color.Red,
                            size = size
                        )
                    }
                }
            }
    }


@Preview
@Composable
fun OvalDrawingPreview() {
    EyeView(side = Side.RIGHT_SIDE)
}
