package paixao.lueny.devhub.data

import paixao.lueny.devhub.data.retrofitBuilder.RetrofitBuilder
import paixao.lueny.devhub.domain.model.User

class GitHubUserInfrastructure() {
    private val api get() = RetrofitBuilder().create(GitHubService ::class.java)

    suspend fun findProfileBy(user: String): User {
        val profileResponse = api.findProfileBy(user)
        val repositoriesResponse = api.findRepositoriesBy(user)
            
        return User.toDomain(userResponse = profileResponse, repositories = repositoriesResponse)
    }
}