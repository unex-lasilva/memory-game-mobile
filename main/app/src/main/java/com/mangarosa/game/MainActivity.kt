package com.mangarosa.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mangarosa.game.ui.theme.GameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }

    }
}
@Composable
fun MenuScreen(onOptionSelected: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "MENU", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { onOptionSelected(1) }, modifier = Modifier.fillMaxWidth()) {
            Text("INICIAR")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onOptionSelected(2) }, modifier = Modifier.fillMaxWidth()) {
            Text("PONTUAÇÃO PARTICIPANTES")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onOptionSelected(3) }, modifier = Modifier.fillMaxWidth()) {
            Text("REGRAS DO JOGO")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { onOptionSelected(4) }, modifier = Modifier.fillMaxWidth()) {
            Text("SAIR")
        }
    }
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuScreen(onOptionSelected = { option ->
                when(option) {
                    1 -> navController.navigate("tabuleiro")
                    2 -> println("PONTUAÇÃO PARTICIPANTES")
                    3 -> println("REGRAS DO JOGO")
                    4 -> println("SAIR")
                }
            })
        }
        composable("tabuleiro") {
            TabuleiroScreen(onTabuleiroSelected = { tamanho ->
                println("Tamanho escolhido: $tamanho")
                // Aqui você pode navegar pra outra tela ou iniciar o jogo
            })
        }
    }
}

@Composable
fun TabuleiroScreen(onTabuleiroSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("DIGITE O TAMANHO DO TABULEIRO:", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(24.dp))

        Button(onClick = { onTabuleiroSelected("4x4") }, modifier = Modifier.fillMaxWidth()) {
            Text("1 - 4x4")
        }
        Button(onClick = { onTabuleiroSelected("6x6") }, modifier = Modifier.fillMaxWidth()) {
            Text("2 - 6x6")
        }
        Button(onClick = { onTabuleiroSelected("8x8") }, modifier = Modifier.fillMaxWidth()) {
            Text("3 - 8x8")
        }
        Button(onClick = { onTabuleiroSelected("10x10") }, modifier = Modifier.fillMaxWidth()) {
            Text("4 - 10x10")
        }
    }
}