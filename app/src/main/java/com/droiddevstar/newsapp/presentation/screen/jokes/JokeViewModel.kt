package com.droiddevstar.newsapp.presentation.screen.jokes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import com.droiddevstar.newsapp.data.network.JokeDTO
import com.droiddevstar.newsapp.domain.interactors.GetJokeCategoriesFlow
import com.droiddevstar.newsapp.domain.interactors.LoadJokesCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokesApi: ChuckNorrisApiService,
    private val getJokeCategoriesFlow: GetJokeCategoriesFlow,
    loadJokesCategories: LoadJokesCategories
): ViewModel() {

    private val _categoriesFlow: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val categoriesFlow = _categoriesFlow.asStateFlow()

    init {
        loadJokesCategories()
        collectJokeCategories()
    }

    private fun collectJokeCategories() {
        viewModelScope.launch {
            getJokeCategoriesFlow().collect {
                _categoriesFlow.value = it
            }
        }
    }

    fun onCategoryClick(category: String) {
        println("@@@onCategoryClick: $category")
    }
}