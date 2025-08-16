package com.droiddevstar.newsapp.presentation.screen.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.droiddevstar.newsapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val viewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>()

    val drawerState: DrawerState = rememberDrawerState(
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
                    label = { Text(text = stringResource(R.string.game)) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                close()
                            }
                        }

                        viewModel.onGameItemClick()
                    }
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

                        viewModel.onAboutItemClick()
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

                        viewModel.onFunnyJokesItemClick()
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.main_screen))
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.main_screen),
                        fontSize = 20.sp
                    )
                }
            }
        )
    }
}