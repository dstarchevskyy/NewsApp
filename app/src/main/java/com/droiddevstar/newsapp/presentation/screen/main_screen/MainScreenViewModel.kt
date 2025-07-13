package com.droiddevstar.newsapp.presentation.screen.main_screen

import androidx.lifecycle.ViewModel
import com.droiddevstar.newsapp.domain.interactors.navigation.SendNavigationCommand
import com.droiddevstar.newsapp.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val sendNavigationCommand: SendNavigationCommand
) : ViewModel() {
    fun onAboutItemClick() {
        sendNavigationCommand(Screen.About)
    }

    fun onFunnyJokesItemClick() {
        sendNavigationCommand(Screen.FunnyJokesCategories)
    }

}