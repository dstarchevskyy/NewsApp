package com.droiddevstar.newsapp.domain.interactors.navigation

import com.droiddevstar.newsapp.domain.NavigationRepository
import com.droiddevstar.newsapp.presentation.navigation.Screen
import javax.inject.Inject

class SendNavigationCommand @Inject constructor(
    private val navigationRepository: NavigationRepository
) {
    operator fun invoke(screen: Screen) {
            navigationRepository.sendNavigationCommand(screen = screen)
    }
}