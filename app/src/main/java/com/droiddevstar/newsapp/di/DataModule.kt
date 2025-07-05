package com.droiddevstar.newsapp.di

import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import com.droiddevstar.newsapp.data.repository.jokes.JokesRepositoryImpl
import com.droiddevstar.newsapp.domain.jokes_repository.JokesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideJokesRepository(
        chuckNorrisApiService: ChuckNorrisApiService
    ): JokesRepository {
        return JokesRepositoryImpl(chuckNorrisApiService = chuckNorrisApiService)
    }
}