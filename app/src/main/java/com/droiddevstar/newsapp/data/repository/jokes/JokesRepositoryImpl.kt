package com.droiddevstar.newsapp.data.repository.jokes

import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class JokesRepositoryImpl @Inject constructor(
    private val chuckNorrisApiService: ChuckNorrisApiService
): JokesRepository {
    override fun getJokesCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val r: Response<List<String>> = chuckNorrisApiService.getCategories()
            println("@@@r: ${r}")
        }
    }
}