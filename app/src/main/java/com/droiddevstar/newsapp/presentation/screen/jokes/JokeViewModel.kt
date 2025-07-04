package com.droiddevstar.newsapp.presentation.screen.jokes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import com.droiddevstar.newsapp.data.network.JokeDTO
import com.droiddevstar.newsapp.domain.interactors.GetJokesCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokesApi: ChuckNorrisApiService,
    private val getJokesCategories: GetJokesCategories
): ViewModel() {
    private val _joke = mutableStateOf<JokeDTO?>(null)
    val joke: State<JokeDTO?> = _joke

    private val _categories = mutableStateOf<List<String>>(emptyList())
    val categories: State<List<String>> = _categories

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    init {
        getJokesCategories()
    }

    fun getRandomJoke() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response: Response<JokeDTO> = jokesApi.getRandomJoke()
                if (response.isSuccessful) {
                    _joke.value = response.body()
                    _error.value = null
                } else {
                    _error.value = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "Exception: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getJokeByCategories() {
        viewModelScope.launch {
            _isLoading.value = true
            getJokesCategories()
        }
    }
}