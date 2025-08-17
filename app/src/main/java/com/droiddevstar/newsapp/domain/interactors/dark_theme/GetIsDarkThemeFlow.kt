package com.droiddevstar.newsapp.domain.interactors.dark_theme

import com.droiddevstar.newsapp.domain.repository.DarkThemeRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetIsDarkThemeFlow @Inject constructor(
    private val darkThemeRepository: DarkThemeRepository
) {
    operator fun invoke(): StateFlow<Boolean> {
        return darkThemeRepository.getIsDarkThemeFlow()
    }
}