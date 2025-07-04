package com.droiddevstar.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.droiddevstar.newsapp.presentation.screen.LoginScreen
import com.droiddevstar.newsapp.presentation.screen.MainScreen
import com.droiddevstar.newsapp.presentation.screen.RegisterScreen
import com.droiddevstar.newsapp.presentation.screen.about.AboutScreen
import com.droiddevstar.newsapp.presentation.screen.jokes.JokesScreen
import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object Login: Screen()
    @Serializable
    data object Register: Screen()
    @Serializable
    data object Main: Screen()
    @Serializable
    data object About: Screen()
    @Serializable
    data object FunnyJokes: Screen()
}

@Composable
fun MainNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.Login
    ) {
        composable<Screen.FunnyJokes> {
            JokesScreen()
        }
        composable<Screen.About> {
            AboutScreen(
                onNavigate = { navigateTo ->
                    navHostController.navigate(navigateTo)
                }
            )
        }
        composable<Screen.Login> {
            LoginScreen(
                onNavigate = { navigateTo ->
                    navHostController.navigate(navigateTo)
                }
            )
        }
        composable<Screen.Register> {
            RegisterScreen { navigateTo ->
                navHostController.navigate(navigateTo)
            }
        }
        composable<Screen.Main> {
            MainScreen { navigateTo ->
                navHostController.navigate(navigateTo)
            }
        }

    }
}