package com.droiddevstar.newsapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.domain.interactors.dark_theme.GetIsDarkThemeFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getIsDarkThemeFlow: GetIsDarkThemeFlow
): ViewModel() {
    private val _isDarkTheme: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    init {
        viewModelScope.launch {
            getIsDarkThemeFlow().collect {
                _isDarkTheme.value = it
            }
        }
    }
}