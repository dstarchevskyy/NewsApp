package com.droiddevstar.newsapp.presentation.screen.state

import com.droiddevstar.newsapp.util.Result

sealed class RegisterScreenEvent {
    data class UserNameUpdated(val newUserName: String) : RegisterScreenEvent()
    data class EmailUpdated(val newEmail: String) : RegisterScreenEvent()
    data class PasswordUpdated(val newPassword: String) : RegisterScreenEvent()
    data object RegisterBtnClicked : RegisterScreenEvent()
}

data class RegisterScreenState(
    val userName: String = "",
    val email: String = "",
    val password: String = "",
    val registerResult: Result? = null
)