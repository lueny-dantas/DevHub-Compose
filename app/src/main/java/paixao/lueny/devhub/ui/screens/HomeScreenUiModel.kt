package paixao.lueny.devhub.ui.screens

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import paixao.lueny.devhub.data.GitHubUserInfrastructure
import paixao.lueny.devhub.domain.model.User

data class HomeScreenState(
    val user: User = User(),
    val isLoading: Boolean = true,
    val error: Throwable? = null
)

internal class HomeScreenUiModel {
    val userService = GitHubUserInfrastructure()

    private val _uiState = MutableStateFlow(HomeScreenState())
    val uiState = _uiState.asStateFlow()


    suspend fun retrieveUserProfile(userAccessName: String) {
        _uiState.emit(HomeScreenState(isLoading = true))
        runCatching {
            userService.findProfileBy(userAccessName)
        }.fold(
            onSuccess = { user ->
                _uiState.emit(HomeScreenState(user = user, isLoading = false))
            },
            onFailure = { error ->
                _uiState.emit(HomeScreenState(isLoading = false, error = error))
            }
        )
    }

}