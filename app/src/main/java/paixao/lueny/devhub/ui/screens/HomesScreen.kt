package paixao.lueny.devhub.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import paixao.lueny.devhub.R
import paixao.lueny.devhub.ui.webclient.model.GitHubRepository
import paixao.lueny.devhub.ui.webclient.model.GitHubWebClient

@Composable
fun ProfileScreen(
    user: String,
    webClient: GitHubWebClient = GitHubWebClient()
) {
    val uiState = webClient.uiState
    LaunchedEffect(null) {
        webClient.findProfileBy(user)
    }
    Profile(uiState)

}

@Composable
fun Profile(uiState: ProfileUiState) {
    LazyColumn {
        item {
            ProfileHeader(uiState)
        }
        item {
            if (uiState.repositories.isNotEmpty()) {
                Text(
                    text = "Repositórios", Modifier.padding(8.dp),
                    fontSize = 24.sp
                )
            }
        }
        items(uiState.repositories) { repo ->
            RepositoryItem(repo = repo)
        }
    }
}

@Composable
private fun ProfileHeader(state: ProfileUiState) {
    Column {
        val boxHeight = remember { 150.dp }
        val imageHeight = remember { boxHeight }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFF2d333b), shape = RoundedCornerShape(
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    )
                )
                .height(boxHeight)
        ) {
            AsyncImage(
                state.image,
                contentDescription = "userProfile pic",
                placeholder = painterResource(R.drawable.user_placeholder),
                modifier = Modifier
                    .offset(y = imageHeight / 2)
                    .size(imageHeight)
                    .align(Alignment.BottomCenter)
                    .clip(CircleShape),
            )
        }
        Spacer(modifier = Modifier.height(imageHeight / 2))
        Column(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                state.name,
                fontSize = 32.sp
            )
            Text(
                state.user,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            state.bio,
            Modifier
                .padding(
                    start = 8.dp,
                    bottom = 8.dp,
                    end = 8.dp
                )
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RepositoryItem(repo: GitHubRepository) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column {
            Text(
                repo.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF2d333b))
                    .padding(8.dp),
                fontSize = 24.sp,
                color = Color.White
            )
            if (repo.description.isNotBlank()) {
                Text(
                    repo.description,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepositoryItemPreview() {
    RepositoryItem(
        repo = GitHubRepository(
            name = "lueny-dantas",
            description = "Android Developer Jr"
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileWithRepositoriesPreview() {
    Profile(
        uiState = ProfileUiState(
            user = "lueny-dantas",
            image = "https://avatars.githubusercontent.com/u/8989346?v=4",
            name = "Lueny Dantas",
            bio = "Android Developer",
            repositories = listOf(
                GitHubRepository(name = "github-compose"),
                GitHubRepository(
                    name = "ceep-compose",
                    description = "Sample project to practice the Jetpack Compose Apps"
                ),
                GitHubRepository(
                    name = "orgs-jetpack-compose",
                    description = "Projeto de simulação do e-commerce de produtos naturais com a finalidade de treinar o Jetpack Compose"
                )
            )
        )
    )
}

data class ProfileUiState(
    val user: String = "",
    val image: String = "",
    val name: String = "",
    val bio: String = "",
    val repositories: List<GitHubRepository> = emptyList()
)


