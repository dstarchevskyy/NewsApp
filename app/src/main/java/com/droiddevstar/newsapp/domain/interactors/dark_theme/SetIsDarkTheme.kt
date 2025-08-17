package com.droiddevstar.newsapp.domain.interactors.dark_theme

import com.droiddevstar.newsapp.domain.repository.DarkThemeRepository
import javax.inject.Inject

class SetIsDarkTheme @Inject constructor(
    private val darkThemeRepository: DarkThemeRepository
) {
    operator fun invoke(isDarkTheme: Boolean) {
        darkThemeRepository.setIsDarkTheme(isDarkTheme = isDarkTheme)
    }
}