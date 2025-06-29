package com.droiddevstar.newsapp.presentation.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.data.repository.AuthRepository
import com.droiddevstar.newsapp.presentation.screen.state.LoginScreenEvent
import com.droiddevstar.newsapp.presentation.screen.state.LoginScreenState
import com.droiddevstar.newsapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
    var state: LoginScreenState by mutableStateOf(LoginScreenState())
        private set

    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.EmailUpdated -> {
                this.state = state.copy(email = event.newEmail)
            }
            is LoginScreenEvent.PasswordUpdated -> {
                this.state = state.copy(password = event.newPassword)
            }
            LoginScreenEvent.LoginBtnClick -> {
                login()
            }
        }
    }

    private fun login() = viewModelScope.launch(Dispatchers.IO) {
        val email: String = state.email
        val password: String = state.password

        if (email.isEmpty()
            || password.isEmpty()) return@launch

        val result: Result = authRepository.login(
            email = email,
            password = password
        )
        println("@@@result: $result")
        this@LoginScreenViewModel.state = state.copy(loginResult = result)
    }
}