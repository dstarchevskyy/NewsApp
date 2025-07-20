package com.droiddevstar.newsapp.domain.interactors

import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import com.droiddevstar.newsapp.domain.model.JokeModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetSavedJokesFlow @Inject constructor(
    private val jokesRepository: JokesRepository
) {
    operator fun invoke(): StateFlow<List<JokeModel>> {
        return jokesRepository.getSavedJokesFlow()
    }

}