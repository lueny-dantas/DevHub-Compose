package paixao.lueny.devhub.data.models

import com.squareup.moshi.Json

data class GitHubProfileResponse(
    val login:String,
    @field:Json(name = "avatar_url") val avatar: String,
    val name:String,
    val bio: String
)

