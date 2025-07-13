package com.droiddevstar.newsapp.presentation.navigation

import androidx.lifecycle.ViewModel
import com.droiddevstar.newsapp.domain.interactors.navigation.GetNavigationCommandsFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor(
    getNavigationCommandsFlow: GetNavigationCommandsFlow
) : ViewModel() {

    val navigationCommandsFlow = getNavigationCommandsFlow.invoke()
}