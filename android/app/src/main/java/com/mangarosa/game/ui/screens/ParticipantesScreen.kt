package com.mangarosa.game.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.compose.ui.unit.dp
import com.mangarosa.game.navigation.Routes
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun ParticipantesScreen(
    onNavigate: (String) -> Unit
) {
    val text1 = remember { mutableStateOf("") }
    val text2 = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Digite o nome dos Participantes:",
            style = MaterialTheme.typography.headlineMedium
        )

        OutlinedTextField(
            value = text1.value,
            onValueChange = { text1.value = it },
            label = { Text("Participante 1") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text2.value,
            onValueChange = { text2.value = it },
            label = { Text("Participante 2") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                // Codifica os nomes e navega
                val encodedP1 = java.net.URLEncoder.encode(text1.value, "UTF-8")
                val encodedP2 = java.net.URLEncoder.encode(text2.value, "UTF-8")
                onNavigate("${Routes.TABULEIRO}/$encodedP1/$encodedP2")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CONTINUAR")
        }
    }
}