package com.droiddevstar.newsapp.presentation.screen.about

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.droiddevstar.newsapp.R
import com.droiddevstar.newsapp.presentation.navigation.Screen

@Composable
fun AboutScreen(
    onNavigate: (Screen) -> Unit
) {
    Text(text = stringResource(id = R.string.about))
}