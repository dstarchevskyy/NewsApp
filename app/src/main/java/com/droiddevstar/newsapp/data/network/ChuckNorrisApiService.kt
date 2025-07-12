package com.droiddevstar.newsapp.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApiService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): Response<JokeDTO>

    @GET("jokes/random?")
    suspend fun getRandomJokeByCategory(
        @Query("category") category: String
    ): JokeDTO?

    @GET("jokes/categories")
    suspend fun getCategories(): List<String>
}

const val CATEGORIES_ENDPOINT = "jokes/categories"