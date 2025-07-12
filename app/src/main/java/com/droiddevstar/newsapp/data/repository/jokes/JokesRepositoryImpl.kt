package com.droiddevstar.newsapp.data.repository.jokes

import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import com.droiddevstar.newsapp.data.network.JokeDTO
import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class JokesRepositoryImpl @Inject constructor(
    private val chuckNorrisApiService: ChuckNorrisApiService
): JokesRepository {

    override fun loadJokesCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val jokeCategories: List<String> = chuckNorrisApiService.getCategories()

            saveJokesCategories(categories = jokeCategories)
        }
    }

    override fun loadJokesBySelectedCategory() {
        CoroutineScope(Dispatchers.IO).launch {
            val selectedCategory: String = JokesCache.getSelectedJokeCategoryFlow().value ?: return@launch
            val jokeDTO: JokeDTO? = chuckNorrisApiService.getRandomJokeByCategory(
                category = selectedCategory
            )

            JokesCache.saveLoadedJoke(jokeText = jokeDTO?.value ?: return@launch)
            println("@@@response: $jokeDTO")
        }
    }

    override fun saveJokesCategories(categories: List<String>) {
        JokesCache.saveJokeCategories(categories = categories)
    }

    override fun getJokesCategoriesFlow(): StateFlow<List<String>> {
        return JokesCache.getJokeCategoriesFlow()
    }

    override fun saveSelectedJokeCategory(category: String) {
        JokesCache.saveJokeCategories(category = category)
    }

    override fun getSelectedJokeCategoryFlow(): StateFlow<String?> {
        return JokesCache.getSelectedJokeCategoryFlow()
    }

    override fun getSavedJokesFlow(): StateFlow<List<String>> {
        return JokesCache.getSavedJokesFlow()
    }
}