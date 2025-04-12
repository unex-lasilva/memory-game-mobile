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


@Composable
fun ParticipantesScreen(
    onNavigate: (String) -> Unit
) {
    val text1 = "";
    val text2 = "";

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
            value = text1,
            onValueChange = { },
            label = { Text("Participante 1") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text2,
            onValueChange = { },
            label = { Text("Participante 2") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { onNavigate(Routes.TABULEIRO) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CONTINUAR")
        }
    }
}