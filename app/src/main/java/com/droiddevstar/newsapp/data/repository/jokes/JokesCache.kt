package com.droiddevstar.newsapp.data.repository.jokes

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object JokesCache {
    private val jokeCategoriesFlow: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

    fun saveJokeCategories(categories: List<String>) {
        jokeCategoriesFlow.value = categories
    }

    fun getJokeCategoriesFlow(): StateFlow<List<String>> {
        return jokeCategoriesFlow
    }
}