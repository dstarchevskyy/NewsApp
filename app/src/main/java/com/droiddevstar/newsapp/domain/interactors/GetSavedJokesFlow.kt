package com.droiddevstar.newsapp.domain.interactors

import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetSavedJokesFlow @Inject constructor(
    private val jokesRepository: JokesRepository
) {
    operator fun invoke(): StateFlow<List<String>> {
        return jokesRepository.getSavedJokesFlow()
    }

}