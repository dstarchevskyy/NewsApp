package com.droiddevstar.newsapp.presentation.screen.jokes_list
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.domain.interactors.LoadJokesBySelectedCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesListViewModel @Inject constructor(
    private val loadJokesBySelectedCategory: LoadJokesBySelectedCategory
) : ViewModel() {

    init {
        loadJokes()
    }

    fun loadJokes() {
        viewModelScope.launch {
            loadJokesBySelectedCategory()
        }
    }
}