package paixao.lueny.devhub.ui.webclient.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import paixao.lueny.devhub.ui.githubservice.GitHubService
import paixao.lueny.devhub.ui.screens.ProfileUiState
import paixao.lueny.devhub.ui.webclient.RetrofitInit

class GitHubWebClient(
    private val service:GitHubService = RetrofitInit().gitHubService
) {
    var uiState by mutableStateOf(ProfileUiState())
        private set
    suspend fun findProfileBy(user: String) {
        try {
            val profile = service.findProfileBy(user).toProfileUiState()
            val repositories = service.findRepositoriesBy(user).map { it.toGitHubRepository() }
            uiState = profile.copy( repositories = repositories)

        }catch (e: Exception){
            Log.e("GitHubWebClient","findProfileBy: falha ao buscar usuário", e)
        }
    }
}