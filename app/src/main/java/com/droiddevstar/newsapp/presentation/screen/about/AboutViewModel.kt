package com.droiddevstar.newsapp.presentation.screen.about

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.domain.interactors.navigation.SendNavigationCommand
import com.droiddevstar.newsapp.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(
    private val sendNavigationCommand: SendNavigationCommand
): ViewModel() {
    var balabanovTextAlpha: Boolean by mutableStateOf(false)
        private set

    var isEyesVisible: Boolean by mutableStateOf(false)
        private set

    var side: Side? by mutableStateOf(null)
        private set

    fun addMem() {
        viewModelScope.launch {
            balabanovTextAlpha = true
            delay(3_000)
            balabanovTextAlpha = false
        }
    }

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

    fun onCloseClick() {
        sendNavigationCommand(Screen.NavigateBack)
    }

    fun showEyes() {
        isEyesVisible = true
    }

    fun onTap(side: Side) {
        this.side = side
    }
}