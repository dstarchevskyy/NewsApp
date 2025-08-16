package com.droiddevstar.newsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.droiddevstar.newsapp.presentation.screen.LoginScreen
import com.droiddevstar.newsapp.presentation.screen.main_screen.MainScreen
import com.droiddevstar.newsapp.presentation.screen.RegisterScreen
import com.droiddevstar.newsapp.presentation.screen.about.AboutScreen
import com.droiddevstar.newsapp.presentation.screen.game.GameScreen
import com.droiddevstar.newsapp.presentation.screen.joke_categories.JokeCategoriesScreen
import com.droiddevstar.newsapp.presentation.screen.jokes_list.JokesListScreen
import kotlinx.serialization.Serializable

@Serializable
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
    data object Game: Screen()
    @Serializable
    data object FunnyJokesCategories: Screen()
    @Serializable
    data object FunnyJokesList: Screen()
    @Serializable
    data object NavigateBack: Screen()
}

@Composable
fun MainNav(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    navigationViewModel: NavigationViewModel = hiltViewModel()
) {
    LaunchedEffect(
        navigationViewModel
    ) {
        navigationViewModel.navigationCommandsFlow.collect { screen ->
            when (screen) {
                Screen.NavigateBack -> {
                    navHostController.popBackStack()
                }

                else -> {
                    navHostController.navigate(screen) {
                        launchSingleTop = true
                    }
                }
            }
        }
    }

    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.Login
    ) {
        composable<Screen.FunnyJokesCategories> {
            JokeCategoriesScreen()
        }
        composable<Screen.FunnyJokesList> {
            JokesListScreen(
            )
        }
        composable<Screen.About> {
            AboutScreen()
        }
        composable<Screen.Game> {
            GameScreen()
        }
        composable<Screen.Login> {
            LoginScreen()
        }
        composable<Screen.Register> {
            RegisterScreen()
        }
        composable<Screen.Main> {
            MainScreen()
        }
    }
}