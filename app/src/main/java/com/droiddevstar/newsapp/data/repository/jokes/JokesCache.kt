package com.droiddevstar.newsapp.data.repository.jokes

import com.droiddevstar.newsapp.domain.model.JokeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object JokesCache {
    private val jokeCategoriesFlow: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    private val selectedJokeCategoryFlow: MutableStateFlow<String?> = MutableStateFlow(null)
    private val loadedJokesFlow: MutableStateFlow<List<JokeModel>> = MutableStateFlow(emptyList())

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

    fun saveLoadedJoke(jokeModel: JokeModel) {
        val currentJokesList: List<JokeModel> = loadedJokesFlow.value
        val newList: MutableList<JokeModel> = currentJokesList.toMutableList().apply {
            add(jokeModel)
        }
        loadedJokesFlow.value = newList
    }

    fun getSavedJokesFlow(): StateFlow<List<JokeModel>> {
        return loadedJokesFlow.asStateFlow()
    }
}