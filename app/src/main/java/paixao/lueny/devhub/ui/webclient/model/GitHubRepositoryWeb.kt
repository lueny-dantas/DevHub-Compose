package paixao.lueny.devhub.ui.webclient.model

data class GitHubRepositoryWeb(
    val name: String = "",
    val description: String? = null
)

fun GitHubRepositoryWeb.toGitHubRepository() = GitHubRepository(
    name = name,
    description = description ?: ""
)