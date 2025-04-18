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
    tamanho : Int,
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
            label = { Text("Participante Azul") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = text2.value,
            onValueChange = { text2.value = it },
            label = { Text("Participante Vermelho") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                var encodedP1 = java.net.URLEncoder.encode(text1.value, "UTF-8")
                if (encodedP1 == "") {
                    encodedP1 = "PARTICIPANTE01"
                }

                var encodedP2 = java.net.URLEncoder.encode(text2.value, "UTF-8")
                if (encodedP2 == "") {
                    encodedP2 = "PARTICIPANTE02"
                }

                onNavigate("${Routes.TABULEIRO}/$encodedP1/$encodedP2/$tamanho")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CONTINUAR")
        }
    }
}