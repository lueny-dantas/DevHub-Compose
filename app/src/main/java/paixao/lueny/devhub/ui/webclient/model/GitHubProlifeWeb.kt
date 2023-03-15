package paixao.lueny.devhub.ui.webclient.model

import com.squareup.moshi.Json
import paixao.lueny.devhub.ui.screens.ProfileUiState

data class GitHubProlifeWeb(
    val login:String,
    @field:Json(name = "avatar_url")
    val avatar: String,
    val name:String,
    val bio: String
)
fun GitHubProlifeWeb.toProfileUiState(): ProfileUiState {
    return ProfileUiState(
        user = login,
        image = avatar,
        name = name,
        bio = bio
    )
}
