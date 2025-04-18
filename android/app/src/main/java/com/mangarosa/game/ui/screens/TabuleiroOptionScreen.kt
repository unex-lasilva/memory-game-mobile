package com.mangarosa.game.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mangarosa.game.navigation.Routes


@Composable
fun TabuleiroOptionScreen(
    onNavigate: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("DIGITE O TAMANHO DO TABULEIRO:", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(24.dp))

        Button(onClick = { onNavigate("${Routes.PARTICIPANTE}/${4}")  }, modifier = Modifier.fillMaxWidth()) {
            Text("1 - 4x4")
        }
        Button(onClick = { onNavigate("${Routes.PARTICIPANTE}/${6}") }, modifier = Modifier.fillMaxWidth()) {
            Text("2 - 6x6")
        }
        Button(onClick = { onNavigate("${Routes.PARTICIPANTE}/${8}")  }, modifier = Modifier.fillMaxWidth()) {
            Text("3 - 8x8")
        }
        Button(onClick = { onNavigate("${Routes.PARTICIPANTE}/${10}") }, modifier = Modifier.fillMaxWidth()) {
            Text("4 - 10x10")
        }
    }
}