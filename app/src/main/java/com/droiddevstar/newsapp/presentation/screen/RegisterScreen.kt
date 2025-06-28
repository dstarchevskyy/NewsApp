package com.droiddevstar.newsapp.presentation.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.droiddevstar.newsapp.R
import com.droiddevstar.newsapp.presentation.navigation.Screen
import com.droiddevstar.newsapp.presentation.screen.state.RegisterScreenEvent
import com.droiddevstar.newsapp.presentation.screen.state.RegisterScreenState
import com.droiddevstar.newsapp.presentation.screen.viewmodel.RegisterViewModel
import com.droiddevstar.newsapp.presentation.ui.component.StyledButton
import com.droiddevstar.newsapp.util.Result

@Composable
fun RegisterScreen(
    onNavigate: (Screen) -> Unit
) {
    val viewModel: RegisterViewModel = hiltViewModel<RegisterViewModel>()

    val context: Context = LocalContext.current
    
    LaunchedEffect(viewModel.state.registerResult) {
        viewModel.state.registerResult?.let { registerResult ->
            when (registerResult) {
                is Result.Success<*> -> {
                    onNavigate(Screen.Main)
                }
                is Result.Failure<*> -> {
                    Toast.makeText(
                        context,
                        registerResult.msg,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }


    LaunchedEffect(viewModel.state.registerResult) {
        viewModel.state.registerResult?.let { registerResult ->
            when (registerResult) {
                is Result.Success<*> -> {
                    onNavigate(Screen.Main)
                }

                is Result.Failure<*> -> {
                    Toast.makeText(
                        context, registerResult.msg, Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    RegisterView(
        state = viewModel.state,
        onEvent = viewModel::onEvent,
        onNavigate = onNavigate
    )
}

@Composable
fun RegisterView(
    state: RegisterScreenState = RegisterScreenState(),
    onEvent: (RegisterScreenEvent) -> Unit = {},
    onNavigate: (Screen) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 100.dp)
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 180.dp),
            value = state.userName,
            onValueChange = {
                onEvent(RegisterScreenEvent.UserNameUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Person),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.enter_username)
                )
            }
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 10.dp),
            value = state.email,
            onValueChange = {
                onEvent(RegisterScreenEvent.EmailUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Email),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.enter_email)
                )
            }
        )

        OutlinedTextField(
            modifier = Modifier.padding(top = 10.dp),
            value = state.password,
            onValueChange = {
                onEvent(RegisterScreenEvent.PasswordUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Lock),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.enter_password)
                )
            }
        )

        StyledButton(
            onClick = { onEvent(RegisterScreenEvent.RegisterBtnClicked) },
            modifier = Modifier.padding(top = 100.dp)
        ) {
            Text(
                text = stringResource(id = R.string.register)
            )
        }

        Text(
            text = stringResource(id = R.string.already_have_an_account),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable {
                    onNavigate(Screen.Login)
                }
        )
    }
}
