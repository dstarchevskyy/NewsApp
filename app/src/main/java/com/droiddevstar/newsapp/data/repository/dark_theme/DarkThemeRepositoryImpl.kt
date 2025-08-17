package com.droiddevstar.newsapp.data.repository.dark_theme

import com.droiddevstar.newsapp.domain.repository.DarkThemeRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class DarkThemeRepositoryImpl @Inject constructor() : DarkThemeRepository {
    override fun setIsDarkTheme(isDarkTheme: Boolean) {
        DarkThemeCache.setIsDarkTheme(isDarkTheme = isDarkTheme)
    }

    override fun getIsDarkThemeFlow(): StateFlow<Boolean> {
        return DarkThemeCache.getIsDarkThemeFlow()
    }
}