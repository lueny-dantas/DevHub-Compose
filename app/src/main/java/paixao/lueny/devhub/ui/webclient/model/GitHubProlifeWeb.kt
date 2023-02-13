package paixao.lueny.devhub.ui.webclient.model

import com.squareup.moshi.Json

data class GitHubProlifeWeb(
    val login:String,
    @field:Json(name = "avatar_url")
    val avatar: String,
    val name:String,
    val bio: String
)
