package com.droiddevstar.newsapp.presentation.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droiddevstar.newsapp.R
import com.droiddevstar.newsapp.presentation.navigation.Screen
import com.droiddevstar.newsapp.presentation.screen.state.LoginScreenEvent
import com.droiddevstar.newsapp.presentation.screen.state.LoginScreenState
import com.droiddevstar.newsapp.presentation.screen.viewmodel.LoginScreenViewModel
import com.droiddevstar.newsapp.presentation.ui.component.StyledButton
import com.droiddevstar.newsapp.util.Result


@Composable
fun LoginScreen(
    onNavigate: (Screen) -> Unit
) {
    val viewModel: LoginScreenViewModel = hiltViewModel<LoginScreenViewModel>()
    val context: Context = LocalContext.current

    LaunchedEffect(viewModel.state.loginResult) {
        viewModel.state.loginResult?.let { loginResult ->
            when(loginResult) {
                is Result.Success<*> -> {
                    onNavigate(Screen.Main)
                }
                is Result.Failure<*> -> {
                    Toast.makeText(
                        context,
                        (viewModel.state.loginResult as Result.Failure<*>).msg,
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    LoginView(
        state = viewModel.state,
        onNavigate = onNavigate,
        onEvent = viewModel::onEvent
    )
}

@Composable
fun LoginView(
    onNavigate: (Screen) -> Unit = {},
    state: LoginScreenState = LoginScreenState(),
    onEvent: (LoginScreenEvent) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 25.sp,
            modifier = Modifier
                .padding(top = 100.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "My Image",
            modifier = Modifier
                .size(160.dp)
                .padding(top = 20.dp)
        )

        OutlinedTextField(
            value = state.email,
            onValueChange = {
                onEvent(LoginScreenEvent.EmailUpdated(newEmail = it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(
                        image = Icons.Outlined.Email
                    ),
                    contentDescription = "Email"
                )
            },
            placeholder = {
                Text(text  = stringResource(id = R.string.enter_email))
            }
        )

        OutlinedTextField(
            value = state.password,
            onValueChange = {
                onEvent(LoginScreenEvent.PasswordUpdated(newPassword = it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(
                        image = Icons.Outlined.Lock
                    ),
                    contentDescription = "Email"
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.enter_password))
            },
            modifier = Modifier
                .padding(top = 10.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        StyledButton(
            onClick = {
                onEvent(LoginScreenEvent.LoginBtnClick)
            },
            modifier = Modifier.padding(top = 50.dp)) {
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 19.sp
            )
        }

        Text(
            text = stringResource(id = R.string.no_account_register),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable {
                    onNavigate(Screen.Register)
                }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginView()
}