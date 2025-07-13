package com.droiddevstar.newsapp.data.navigation

import com.droiddevstar.newsapp.domain.NavigationRepository
import com.droiddevstar.newsapp.presentation.navigation.Screen
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class NavigationRepositoryImpl @Inject constructor(
) : NavigationRepository {
    override fun sendNavigationCommand(screen: Screen) {
        NavigationCache.sendNavigationCommand(screen = screen)
    }

    override fun getNavigationCommandsFlow(): SharedFlow<Screen> {
        return NavigationCache.getNavigationCommandsFlow()
    }
}