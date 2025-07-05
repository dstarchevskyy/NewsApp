package com.droiddevstar.newsapp.data.network

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

class OkHttpLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.d("OKHTTP", message)
    }
}