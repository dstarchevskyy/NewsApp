package com.droiddevstar.newsapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object BatteryInfoReceiver : BroadcastReceiver() {
    private val _tempFlow: MutableStateFlow<Int> = MutableStateFlow(0)

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            _tempFlow.value = it.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0)
        }
    }


}