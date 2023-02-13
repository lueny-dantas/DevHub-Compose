package paixao.lueny.devhub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import paixao.lueny.devhub.R
import paixao.lueny.devhub.ui.theme.Purple200
import paixao.lueny.devhub.ui.theme.Teal200

@Composable

fun ProfileScreen() {
    Column(
        Modifier
            .heightIn(250.dp, 300.dp)
            .width(200.dp)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Purple200, Teal200)
                    )
                )
                .fillMaxWidth()
        ) {
            AsyncImage(
                "https://avatars.githubusercontent.com/u/98789294?v=4",
                contentDescription = "foto do perfil",
                placeholder = painterResource(id = R.drawable.user_placeholder),
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = 100.dp / 2)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(Modifier.height(100.dp / 2))
        Column(
            Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Lueny Dantas",
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()

            )
            Text(
                text = "lueny-dantas",
                fontSize = 14.sp,
                fontWeight = FontWeight(700),
                maxLines = 2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Desenvolvedora Android",
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                maxLines = 2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun InformationProfilePreview() {
    ProfileScreen()
}