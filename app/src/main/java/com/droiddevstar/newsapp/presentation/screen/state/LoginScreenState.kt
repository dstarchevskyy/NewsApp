package com.droiddevstar.newsapp.presentation.screen.state

import com.droiddevstar.newsapp.util.Result

sealed class LoginScreenEvent {
    data class EmailUpdated(val newEmail: String): LoginScreenEvent()
    data class PasswordUpdated(val newPassword: String): LoginScreenEvent()
    data object LoginBtnClick : LoginScreenEvent()
}

data class LoginScreenState(
    val email: String = "asdf",
    val password: String = "asdf",
    val loginResult: Result? = null
)