package com.droiddevstar.newsapp.data.mapper

import com.droiddevstar.newsapp.data.network.JokeDTO
import com.droiddevstar.newsapp.domain.model.JokeModel

object JokeDTOtoJokeModel {
    fun jokeDTOtoJokeModel(jokeDto: JokeDTO?): JokeModel = jokeDto?.let {
        JokeModel(
            categories = it.categories ?: emptyList(),
            createdAt = it.createdAt ?: "",
            iconUrl = it.iconUrl ?: "",
            id = it.id ?: "",
            updatedAt = it.updatedAt ?: "",
            url = it.url ?: "",
            value = it.value ?: ""
        )
    } ?: JokeModel()
}