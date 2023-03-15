package paixao.lueny.devhub.ui.githubservice

import paixao.lueny.devhub.ui.webclient.model.GitHubProlifeWeb
import paixao.lueny.devhub.ui.webclient.model.GitHubRepositoryWeb
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user:String):GitHubProlifeWeb

    @GET("/users/{user}/repos")
    suspend fun findRepositoriesBy(@Path("user") user: String): List<GitHubRepositoryWeb>

}