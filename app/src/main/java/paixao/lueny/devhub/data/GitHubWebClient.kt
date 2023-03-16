package paixao.lueny.devhub.domain.model

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import paixao.lueny.devhub.data.GitHubService
import paixao.lueny.devhub.data.retrofitBuilder.RetrofitBuilder

class GitHubWebClient(
    private val service: GitHubService = RetrofitBuilder().create(GitHubService::class.java)
) {
    var uiState by mutableStateOf(User())
        private set

    suspend fun findProfileBy(user: String) {
        try {
            val repositories = service.findRepositoriesBy(user)
            val profile = service.findProfileBy(user)
            uiState = User.toDomain(userResponse = profile, repositories = repositories)

        } catch (e: Exception) {
            Log.e("GitHubWebClient", "findProfileBy: falha ao buscar usuário", e)
        }
    }
}