package com.droiddevstar.newsapp.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.droiddevstar.newsapp.data.network.ChuckNorrisApiService
import com.droiddevstar.newsapp.data.network.OkHttpLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
        val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(OkHttpLogger()).apply {
            level = HttpLoggingInterceptor.Level.BODY // Change level as needed
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(ChuckerInterceptor(context))
            .build()
    }
}