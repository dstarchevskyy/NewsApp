package com.droiddevstar.newsapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droiddevstar.newsapp.R
import com.droiddevstar.newsapp.presentation.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    onNavigate: (Screen) -> Unit
) {
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = stringResource(id = R.string.app_name),
                    modifier = Modifier.padding(16.dp)
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = stringResource(R.string.about)) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                        onNavigate(Screen.About)
                    }
                )

                NavigationDrawerItem(
                    label = { Text(text = stringResource(R.string.funny_jokes)) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }
                        onNavigate(Screen.FunnyJokes)
                    }
                )

            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.app_name),
                fontSize = 30.sp
            )
            Text(
                text = stringResource(R.string.main_screen),
                fontSize = 20.sp
            )
        }
    }
}