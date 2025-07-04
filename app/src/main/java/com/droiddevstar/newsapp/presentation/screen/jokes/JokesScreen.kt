package com.droiddevstar.newsapp.presentation.screen.jokes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.droiddevstar.newsapp.R

@Composable
fun JokesScreen() {
    val viewModel: JokeViewModel = hiltViewModel<JokeViewModel>()

//    LaunchedEffect(true) {
//        viewModel.getJokeByCategories()
//    }

    Text(
        text = stringResource(
            id = R.string.funny_jokes
        ),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        modifier = Modifier.fillMaxSize()
            .padding(top = 20.dp)
    )
}