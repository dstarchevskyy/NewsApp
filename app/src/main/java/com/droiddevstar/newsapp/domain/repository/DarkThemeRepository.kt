package com.droiddevstar.newsapp.domain.repository

import kotlinx.coroutines.flow.StateFlow

interface DarkThemeRepository {
    fun setIsDarkTheme(isDarkTheme: Boolean)
    fun getIsDarkThemeFlow(): StateFlow<Boolean>
}