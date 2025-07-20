package com.droiddevstar.newsapp.domain.jokes_repository

import com.droiddevstar.newsapp.domain.model.JokeModel
import kotlinx.coroutines.flow.StateFlow

interface JokesRepository {
    fun loadJokesCategories()
    fun loadJokesBySelectedCategory()

    fun saveJokesCategories(categories: List<String>)
    fun getJokesCategoriesFlow(): StateFlow<List<String>>

    fun saveSelectedJokeCategory(category: String)
    fun getSelectedJokeCategoryFlow(): StateFlow<String?>

    fun getSavedJokesFlow(): StateFlow<List<JokeModel>>
}