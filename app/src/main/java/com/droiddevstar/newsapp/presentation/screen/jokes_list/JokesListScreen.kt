package com.droiddevstar.newsapp.presentation.screen.jokes_list

import androidx.compose.foundation.layout.fillMaxWidth
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
import com.droiddevstar.newsapp.presentation.screen.joke_categories.JokeCategoriesViewModel

@Composable
fun JokesListScreen() {
    val viewModel: JokesListViewModel = hiltViewModel<JokesListViewModel>()

    LaunchedEffect(true) {
        viewModel.loadJokes()
    }

    Text(
        text = stringResource(
            id = R.string.funny_jokes_list
        ),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        modifier = Modifier.fillMaxWidth()
            .padding(top = 20.dp)
    )

}