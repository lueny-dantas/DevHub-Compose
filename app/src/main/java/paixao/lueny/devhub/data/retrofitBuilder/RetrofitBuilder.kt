package paixao.lueny.devhub.data.retrofitBuilder

import paixao.lueny.devhub.data.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    operator fun invoke(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}