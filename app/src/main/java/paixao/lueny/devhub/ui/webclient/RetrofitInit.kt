package paixao.lueny.devhub.ui.webclient

import paixao.lueny.devhub.ui.githubservice.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInit {

    val gitHubService get() = retrofit.create(GitHubService ::class.java)

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}