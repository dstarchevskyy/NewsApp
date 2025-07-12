package com.droiddevstar.newsapp.domain.interactors

import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import javax.inject.Inject

class SaveSelectedJokeCategory @Inject constructor(
    private val jokesRepository: JokesRepository
) {
    operator fun invoke(jokeCategory: String) {
        jokesRepository.saveSelectedJokeCategory(category = jokeCategory)
    }
}