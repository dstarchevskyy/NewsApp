package com.droiddevstar.newsapp.presentation.screen.about

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(): ViewModel() {
    fun openTelegramOrBrowser(context: Context) {
        val telegramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/dimastarchevsky"))

        // Check if Telegram is installed
        val packageManager = context.packageManager
        val isTelegramInstalled = telegramIntent.resolveActivity(packageManager) != null

        if (isTelegramInstalled) {
            context.startActivity(telegramIntent)
        } else {
            // Fallback to browser
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/dimastarchevsky"))
            context.startActivity(webIntent)
        }
    }

    fun openVkOrBrowser(context: Context) {
        val telegramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/id27741388"))

        val packageManager = context.packageManager
        val isTelegramInstalled = telegramIntent.resolveActivity(packageManager) != null

        if (isTelegramInstalled) {
            context.startActivity(telegramIntent)
        } else {
            // Fallback to browser
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/id27741388"))
            context.startActivity(webIntent)
        }
    }

}