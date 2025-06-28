package com.droiddevstar.newsapp.ui

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _counterState: MutableIntState = mutableIntStateOf(0)
    var counterState: Int by _counterState

    fun incrementCounter() {
        _counterState.intValue++
    }
}