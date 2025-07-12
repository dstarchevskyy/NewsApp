package com.droiddevstar.newsapp.presentation.screen.joke_categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.domain.interactors.GetJokeCategoriesFlow
import com.droiddevstar.newsapp.domain.interactors.LoadJokesCategories
import com.droiddevstar.newsapp.domain.interactors.SaveSelectedJokeCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeCategoriesViewModel @Inject constructor(
    private val getJokeCategoriesFlow: GetJokeCategoriesFlow,
    private val saveSelectedJokeCategory: SaveSelectedJokeCategory,
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
        saveSelectedJokeCategory(jokeCategory = category)
    }
}