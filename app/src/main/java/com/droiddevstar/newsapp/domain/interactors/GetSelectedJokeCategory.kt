package com.droiddevstar.newsapp.domain.interactors

import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetSelectedJokeCategory @Inject constructor(
    private val jokesRepository: JokesRepository
) {
    operator fun invoke(): StateFlow<String?> {
        return jokesRepository.getSelectedJokeCategoryFlow()
    }
}