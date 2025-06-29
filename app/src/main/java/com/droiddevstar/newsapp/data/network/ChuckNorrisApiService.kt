package com.droiddevstar.newsapp.data.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApiService {
    @GET("jokes/random")
    suspend fun getRandomJoke(): Response<JokeDTO>

    @GET("jokes/random")
    suspend fun getRandomJokeByCategory(
        @Query("category") category: String
    ): Response<JokeDTO>

    @GET("jokes/categories")
    suspend fun getCategories(): Response<List<String>>

    companion object {
        private const val BASE_URL = "https://api.chucknorris.io/"

        fun create(): ChuckNorrisApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ChuckNorrisApiService::class.java)
        }
    }
}