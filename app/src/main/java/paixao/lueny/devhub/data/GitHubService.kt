package paixao.lueny.devhub.data

import paixao.lueny.devhub.data.models.GitHubProfileResponse
import paixao.lueny.devhub.data.models.GitHubRepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user:String): GitHubProfileResponse

    @GET("/users/{user}/repos")
    suspend fun findRepositoriesBy(@Path("user") user: String): List<GitHubRepositoryResponse>

}