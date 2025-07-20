package com.droiddevstar.newsapp.presentation.screen.jokes_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.droiddevstar.newsapp.R
import com.droiddevstar.newsapp.domain.model.JokeModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JokesListScreen() {
    val viewModel: JokesListViewModel = hiltViewModel<JokesListViewModel>()

    var showBottomSheet: Boolean by remember {
        mutableStateOf(false)
    }

    var bottomSheetState: SheetState = rememberModalBottomSheetState()

    LaunchedEffect(true) {
        viewModel.loadJokes()
    }

    Column {
        Text(
            text = stringResource(
                id = R.string.funny_jokes_list
            ),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 32.dp)
        )

        val jokesState: State<List<JokeModel>> = viewModel.jokesFlow.collectAsState()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 32.dp,
                    bottom = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(jokesState.value) { jokeModel ->
                Card(modifier = Modifier.fillMaxWidth()
                    .clickable {
                        showBottomSheet = true
                    }) {
                    Text(
                        text = jokeModel.value,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = bottomSheetState
        ) {
            Text(text = "Title")
        }
    }
}