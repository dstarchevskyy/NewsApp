package com.droiddevstar.newsapp.domain.interactors.navigation

import com.droiddevstar.newsapp.domain.NavigationRepository
import com.droiddevstar.newsapp.presentation.navigation.Screen
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class GetNavigationCommandsFlow @Inject constructor(
    private val navigationRepository: NavigationRepository
) {
    operator fun invoke(): SharedFlow<Screen> {
        return navigationRepository.getNavigationCommandsFlow()
    }
}