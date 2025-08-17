package com.droiddevstar.newsapp.presentation.screen.game

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GameScreen() {


    Text(modifier = Modifier.background(color = Color.Red), text = "GameScreen")

}

@Composable
@Preview
fun GameScreenPreview() {
    GameScreen()
}