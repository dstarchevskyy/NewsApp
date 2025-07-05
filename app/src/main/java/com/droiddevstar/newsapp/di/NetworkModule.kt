package com.droiddevstar.newsapp.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideChuckNorrisApiService(
        okHttpClient: OkHttpClient
    ): ChuckNorrisApiService {
        return ChuckNorrisApiService.create(okHttpClient)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext
        context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .build()
    }
}