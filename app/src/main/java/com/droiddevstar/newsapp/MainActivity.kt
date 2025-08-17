package com.droiddevstar.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.droiddevstar.newsapp.presentation.navigation.MainNav
import com.droiddevstar.newsapp.ui.MainActivityViewModel
import com.droiddevstar.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainActivityViewModel = hiltViewModel<MainActivityViewModel>()

            val isDarkTheme: State<Boolean> = viewModel.isDarkTheme.collectAsState()

            NewsAppTheme(darkTheme = isDarkTheme.value) {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background),
                ) { innerPadding ->
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier
) {
    MainNav(
        navHostController = rememberNavController(),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppTheme {
        MainContent()
    }
}