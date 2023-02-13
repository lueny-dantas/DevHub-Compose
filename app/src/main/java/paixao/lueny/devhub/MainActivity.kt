package paixao.lueny.devhub

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import paixao.lueny.devhub.ui.screens.ProfileScreen
import paixao.lueny.devhub.ui.theme.DevHubTheme
import paixao.lueny.devhub.ui.webclient.RetrofitInit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch{
            RetrofitInit().gitHubService.findProfileBy("lueny-dantas")
                .let{
                    Log.i("MainActivity","onCreate: $it")
                }
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    DevHubTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            ProfileScreen()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}