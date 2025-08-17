package com.droiddevstar.newsapp.presentation.screen.main_screen

import androidx.lifecycle.ViewModel
import com.droiddevstar.newsapp.domain.interactors.navigation.SendNavigationCommand
import com.droiddevstar.newsapp.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val sendNavigationCommand: SendNavigationCommand
) : ViewModel() {

    private val _isDarkTheme: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme.asStateFlow()

    fun onAboutItemClick() {
        sendNavigationCommand(Screen.About)
    }

    fun onFunnyJokesItemClick() {
        sendNavigationCommand(Screen.FunnyJokesCategories)
    }

    fun onGameItemClick() {
        sendNavigationCommand(Screen.Game)
    }

    fun onDarkThemeChange() {
        _isDarkTheme.value = !isDarkTheme.value
    }

}