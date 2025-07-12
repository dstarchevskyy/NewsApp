package com.droiddevstar.newsapp.data.repository.jokes

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object JokesCache {
    private val jokeCategoriesFlow: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    private val selectedJokeCategoryFlow: MutableStateFlow<String?> = MutableStateFlow(null)

    fun saveJokeCategories(categories: List<String>) {
        jokeCategoriesFlow.value = categories
    }

    fun getJokeCategoriesFlow(): StateFlow<List<String>> {
        return jokeCategoriesFlow
    }

    fun saveJokeCategories(category: String) {
        selectedJokeCategoryFlow.value = category
    }

    fun getSelectedJokeCategoryFlow(): StateFlow<String?> {
        return selectedJokeCategoryFlow.asStateFlow()
    }
}