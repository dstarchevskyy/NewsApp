package com.droiddevstar.newsapp.domain.interactors

import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import javax.inject.Inject

class GetJokesCategories @Inject constructor(
    private val jokesRepository: JokesRepository
) {
    operator fun invoke() {
        jokesRepository.getJokesCategories()
    }
}