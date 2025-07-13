package com.droiddevstar.newsapp.domain

import com.droiddevstar.newsapp.presentation.navigation.Screen
import kotlinx.coroutines.flow.SharedFlow

interface NavigationRepository {
    fun sendNavigationCommand(screen: Screen)
    fun getNavigationCommandsFlow(): SharedFlow<Screen>
}