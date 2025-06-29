package com.droiddevstar.newsapp.presentation.screen.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.droiddevstar.newsapp.R

@Composable
fun BalabanovView(
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        val arialBlack = FontFamily(
            Font(R.font.arial_black) // Make sure the filename matches exactly
        )

        Text(
            text = stringResource(
                id = R.string.director
            ),
            Modifier.background(
                color = colorResource(id = R.color.transparent_light_grey)
            ),
            style = TextStyle(
                fontFamily = arialBlack,
                fontSize = 20.sp
            )
        )

        Text(
            text = stringResource(
                id = R.string.balabanov
            ),
            textAlign = TextAlign.Center,
            color = Color.Red,
            style = TextStyle(
                fontFamily = arialBlack,
                fontSize = 30.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BalabanovViewPreview() {
    BalabanovView(
        modifier = Modifier.fillMaxWidth()
    )
}