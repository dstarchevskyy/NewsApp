package com.droiddevstar.newsapp.presentation.screen.jokes_list
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.domain.interactors.GetSavedJokesFlow
import com.droiddevstar.newsapp.domain.interactors.LoadJokesBySelectedCategory
import com.droiddevstar.newsapp.domain.model.JokeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesListViewModel @Inject constructor(
    private val loadJokesBySelectedCategory: LoadJokesBySelectedCategory,
    private val getSavedJokesFlow: GetSavedJokesFlow
) : ViewModel() {

    private val _jokesFlow: MutableStateFlow<List<JokeModel>> = MutableStateFlow(emptyList())
    val jokesFlow: StateFlow<List<JokeModel>> = _jokesFlow.asStateFlow()

    private val _selectedJoke: MutableStateFlow<JokeModel?> = MutableStateFlow(null)
    val selectedJoke: StateFlow<JokeModel?> = _selectedJoke

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

    fun onJokeClick(jokeModel: JokeModel) {
        _selectedJoke.value = jokeModel
    }
}