package com.droiddevstar.newsapp.presentation.screen.jokes_list
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.domain.interactors.GetSavedJokesFlow
import com.droiddevstar.newsapp.domain.interactors.LoadJokesBySelectedCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesListViewModel @Inject constructor(
    private val loadJokesBySelectedCategory: LoadJokesBySelectedCategory,
    private val getSavedJokesFlow: GetSavedJokesFlow
) : ViewModel() {

    private val _jokesFlow: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val jokesFlow = _jokesFlow.asStateFlow()

    init {
        collectSavedJokes()
    }

    private fun collectSavedJokes() {
        viewModelScope.launch {
            getSavedJokesFlow().collect {
                _jokesFlow.value = it
            }
        }
    }

    fun loadJokes() {
        viewModelScope.launch {
            loadJokesBySelectedCategory()

        }
    }
}