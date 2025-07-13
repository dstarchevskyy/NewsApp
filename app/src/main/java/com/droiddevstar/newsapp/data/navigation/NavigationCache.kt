package com.droiddevstar.newsapp.data.navigation

import com.droiddevstar.newsapp.presentation.navigation.Screen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object NavigationCache {
    private val navigationCommandFlow: MutableSharedFlow<Screen> = MutableSharedFlow(
        extraBufferCapacity = 1
    )

    fun sendNavigationCommand(screen: Screen) {
        navigationCommandFlow.tryEmit(screen)
    }

    fun getNavigationCommandsFlow(): SharedFlow<Screen> {
        return navigationCommandFlow.asSharedFlow()
    }
}