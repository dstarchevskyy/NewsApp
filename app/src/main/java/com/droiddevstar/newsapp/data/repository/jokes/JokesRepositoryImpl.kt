package com.droiddevstar.newsapp.data.repository.jokes

import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokesRepositoryImpl @Inject constructor(
    private val chuckNorrisApiService: ChuckNorrisApiService
): JokesRepository {

    override fun loadJokesCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val jokeCategories: List<String> = chuckNorrisApiService.getCategories()
            println("@@@jokeCategories: ${jokeCategories}")

            saveJokesCategories(categories = jokeCategories)
        }
    }

    override fun saveJokesCategories(categories: List<String>) {
        JokesCache.saveJokeCategories(categories = categories)
    }

    override fun getJokesCategoriesFlow(): StateFlow<List<String>> {
        return JokesCache.getJokeCategoriesFlow()
    }
}