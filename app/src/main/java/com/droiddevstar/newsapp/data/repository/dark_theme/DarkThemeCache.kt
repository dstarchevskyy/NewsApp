package com.droiddevstar.newsapp.data.repository.dark_theme

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object DarkThemeCache {
    private val isDarkTheme: MutableStateFlow<Boolean> = MutableStateFlow(false)

    fun setIsDarkTheme(isDarkTheme: Boolean) {
        this.isDarkTheme.value = isDarkTheme
    }

    fun getIsDarkThemeFlow(): StateFlow<Boolean> = isDarkTheme.asStateFlow()
}