package com.droiddevstar.newsapp.presentation.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droiddevstar.newsapp.data.repository.AuthRepository
import com.droiddevstar.newsapp.presentation.screen.state.RegisterScreenEvent
import com.droiddevstar.newsapp.presentation.screen.state.RegisterScreenState
import com.droiddevstar.newsapp.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    var state: RegisterScreenState by mutableStateOf(RegisterScreenState())
        private set

    fun onEvent(event: RegisterScreenEvent) {
        when (event) {
            is RegisterScreenEvent.UserNameUpdated -> {
                state = state.copy(
                    userName = event.newUserName
                )
            }

            is RegisterScreenEvent.EmailUpdated -> {
                state = state.copy(
                    email = event.newEmail
                )
            }

            is RegisterScreenEvent.PasswordUpdated -> {
                state = state.copy(
                    password = event.newPassword
                )
            }

            is RegisterScreenEvent.RegisterBtnClicked -> {
                register()
            }
        }
    }

    private fun register() = viewModelScope.launch(Dispatchers.IO) {
        val userName: String = state.userName
        val email: String = state.email
        val password: String = state.password

        if (userName.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
        ) return@launch

        val result: Result = authRepository.register(
            userName = userName,
            email = email,
            password = password
        )

        this@RegisterViewModel.state = state.copy(
            registerResult = result
        )
    }
}