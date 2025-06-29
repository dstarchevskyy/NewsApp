package com.droiddevstar.newsapp.di

import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideChuckNorrisApiService(): ChuckNorrisApiService {
        return ChuckNorrisApiService.create()
    }
}