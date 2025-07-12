package com.droiddevstar.newsapp.domain.jokes_repository

import kotlinx.coroutines.flow.StateFlow

interface JokesRepository {
    fun loadJokesCategories()
    fun loadJokesBySelectedCategory()

    fun saveJokesCategories(categories: List<String>)
    fun getJokesCategoriesFlow(): StateFlow<List<String>>

    fun saveSelectedJokeCategory(category: String)
    fun getSelectedJokeCategoryFlow(): StateFlow<String?>
}