package paixao.lueny.devhub.domain.model

import paixao.lueny.devhub.data.models.GitHubProfileResponse
import paixao.lueny.devhub.data.models.GitHubRepositoryResponse

data class User(
    val userAccessName: String = "",
    val image: String = "",
    val name: String = "",
    val bio: String = "",
    val repositories: List<GitHubRepositoryResponse> = emptyList()
){

    companion object {
        fun toDomain(
            userResponse: GitHubProfileResponse,
            repositories: List<GitHubRepositoryResponse>
        ): User {
            return User(
                userAccessName = userResponse.login,
                image = userResponse.avatar,
                name = userResponse.name,
                bio = userResponse.bio,
                repositories = repositories
            )
        }
    }

}

