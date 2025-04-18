package com.mangarosa.game.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mangarosa.game.models.Carta
import com.mangarosa.game.models.Cor
import com.mangarosa.game.models.Participante
import com.mangarosa.game.models.Rodada
import com.mangarosa.game.models.Tabuleiro
import com.mangarosa.game.navigation.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private fun genarateLista(tamanho: Int): Array<Carta> {
    return when (tamanho) {
        4 -> arrayOf(
            Carta(Cor.BLACK, "K01"),
            Carta(Cor.BLACK, "K01"),
            Carta(Cor.RED, "R01"),
            Carta(Cor.RED, "R01"),
            Carta(Cor.RED, "R02"),
            Carta(Cor.RED, "R02"),
            Carta(Cor.BLUE, "B01"),
            Carta(Cor.BLUE, "B01"),
            Carta(Cor.BLUE, "B02"),
            Carta(Cor.BLUE, "B02"),
            Carta(Cor.YELLOW, "Y01"),
            Carta(Cor.YELLOW, "Y01"),
            Carta(Cor.YELLOW, "Y02"),
            Carta(Cor.YELLOW, "Y02"),
            Carta(Cor.YELLOW, "Y03"),
            Carta(Cor.YELLOW, "Y03")
        )

        6 -> arrayOf(
            Carta(Cor.BLACK, "K01"),
            Carta(Cor.BLACK, "K01"),
            Carta(Cor.RED, "R01"),
            Carta(Cor.RED, "R01"),
            Carta(Cor.RED, "R02"),
            Carta(Cor.RED, "R02"),
            Carta(Cor.RED, "R03"),
            Carta(Cor.RED, "R03"),
            Carta(Cor.RED, "R04"),
            Carta(Cor.RED, "R04"),
            Carta(Cor.RED, "R05"),
            Carta(Cor.BLUE, "B01"),
            Carta(Cor.BLUE, "B01"),
            Carta(Cor.BLUE, "B02"),
            Carta(Cor.BLUE, "B02"),
            Carta(Cor.BLUE, "B03"),
            Carta(Cor.BLUE, "B03"),
            Carta(Cor.BLUE, "B04"),
            Carta(Cor.BLUE, "B04"),
            Carta(Cor.BLUE, "B05"),
            Carta(Cor.YELLOW, "Y01"),
            Carta(Cor.YELLOW, "Y01"),
            Carta(Cor.YELLOW, "Y02"),
            Carta(Cor.YELLOW, "Y02"),
            Carta(Cor.YELLOW, "Y03"),
            Carta(Cor.YELLOW, "Y03"),
            Carta(Cor.YELLOW, "Y04"),
            Carta(Cor.YELLOW, "Y04"),
            Carta(Cor.YELLOW, "Y05"),
            Carta(Cor.YELLOW, "Y05"),
            Carta(Cor.YELLOW, "Y06"),
            Carta(Cor.YELLOW, "Y06"),
            Carta(Cor.YELLOW, "Y07"),
            Carta(Cor.YELLOW, "Y07"),
            Carta(Cor.YELLOW, "Y08"),
            Carta(Cor.YELLOW, "Y08"),
        )

        8 -> arrayOf(
            Carta(Cor.BLACK, "K01"),
            Carta(Cor.BLACK, "K01"),
            Carta(Cor.BLUE, "B01"),
            Carta(Cor.BLUE, "B01"),
            Carta(Cor.BLUE, "B02"),
            Carta(Cor.BLUE, "B02"),
            Carta(Cor.BLUE, "B03"),
            Carta(Cor.BLUE, "B03"),
            Carta(Cor.BLUE, "B04"),
            Carta(Cor.BLUE, "B04"),
            Carta(Cor.BLUE, "B05"),
            Carta(Cor.BLUE, "B05"),
            Carta(Cor.BLUE, "B06"),
            Carta(Cor.BLUE, "B06"),
            Carta(Cor.BLUE, "B07"),
            Carta(Cor.BLUE, "B07"),
            Carta(Cor.BLUE, "B08"),
            Carta(Cor.BLUE, "B08"),
            Carta(Cor.RED, "R01"),
            Carta(Cor.RED, "R01"),
            Carta(Cor.RED, "R02"),
            Carta(Cor.RED, "R02"),
            Carta(Cor.RED, "R03"),
            Carta(Cor.RED, "R03"),
            Carta(Cor.RED, "R04"),
            Carta(Cor.RED, "R04"),
            Carta(Cor.RED, "R05"),
            Carta(Cor.RED, "R05"),
            Carta(Cor.RED, "R06"),
            Carta(Cor.RED, "R06"),
            Carta(Cor.RED, "R07"),
            Carta(Cor.RED, "R07"),
            Carta(Cor.RED, "R08"),
            Carta(Cor.RED, "R08"),
            Carta(Cor.YELLOW, "Y01"),
            Carta(Cor.YELLOW, "Y01"),
            Carta(Cor.YELLOW, "Y02"),
            Carta(Cor.YELLOW, "Y02"),
            Carta(Cor.YELLOW, "Y03"),
            Carta(Cor.YELLOW, "Y03"),
            Carta(Cor.YELLOW, "Y04"),
            Carta(Cor.YELLOW, "Y04"),
            Carta(Cor.YELLOW, "Y05"),
            Carta(Cor.YELLOW, "Y05"),
            Carta(Cor.YELLOW, "Y06"),
            Carta(Cor.YELLOW, "Y06"),
            Carta(Cor.YELLOW, "Y07"),
            Carta(Cor.YELLOW, "Y07"),
            Carta(Cor.YELLOW, "Y08"),
            Carta(Cor.YELLOW, "Y08"),
            Carta(Cor.YELLOW, "Y09"),
            Carta(Cor.YELLOW, "Y09"),
            Carta(Cor.YELLOW, "Y10"),
            Carta(Cor.YELLOW, "Y10"),
            Carta(Cor.YELLOW, "Y10"),
            Carta(Cor.YELLOW, "Y11"),
            Carta(Cor.YELLOW, "Y11"),
            Carta(Cor.YELLOW, "Y12"),
            Carta(Cor.YELLOW, "Y12"),
            Carta(Cor.YELLOW, "Y13"),
            Carta(Cor.YELLOW, "Y13"),
            Carta(Cor.YELLOW, "Y14"),
            Carta(Cor.YELLOW, "Y15"),
            Carta(Cor.YELLOW, "Y15")
        )

        else -> arrayOf(
            Carta(Cor.BLACK, "K01"),
            Carta(Cor.BLACK, "K01"),
            Carta(Cor.BLUE, "B01"),
            Carta(Cor.BLUE, "B01"),
            Carta(Cor.BLUE, "B02"),
            Carta(Cor.BLUE, "B02"),
            Carta(Cor.BLUE, "B03"),
            Carta(Cor.BLUE, "B03"),
            Carta(Cor.BLUE, "B04"),
            Carta(Cor.BLUE, "B04"),
            Carta(Cor.BLUE, "B05"),
            Carta(Cor.BLUE, "B05"),
            Carta(Cor.BLUE, "B06"),
            Carta(Cor.BLUE, "B06"),
            Carta(Cor.BLUE, "B07"),
            Carta(Cor.BLUE, "B07"),
            Carta(Cor.BLUE, "B08"),
            Carta(Cor.BLUE, "B08"),
            Carta(Cor.BLUE, "B09"),
            Carta(Cor.BLUE, "B09"),
            Carta(Cor.BLUE, "B10"),
            Carta(Cor.BLUE, "B10"),
            Carta(Cor.BLUE, "B11"),
            Carta(Cor.BLUE, "B11"),
            Carta(Cor.BLUE, "B12"),
            Carta(Cor.BLUE, "B12"),
            Carta(Cor.BLUE, "B13"),
            Carta(Cor.RED, "R01"),
            Carta(Cor.RED, "R01"),
            Carta(Cor.RED, "R02"),
            Carta(Cor.RED, "R02"),
            Carta(Cor.RED, "R03"),
            Carta(Cor.RED, "R03"),
            Carta(Cor.RED, "R04"),
            Carta(Cor.RED, "R04"),
            Carta(Cor.RED, "R05"),
            Carta(Cor.RED, "R05"),
            Carta(Cor.RED, "R06"),
            Carta(Cor.RED, "R06"),
            Carta(Cor.RED, "R07"),
            Carta(Cor.RED, "R07"),
            Carta(Cor.RED, "R08"),
            Carta(Cor.RED, "R08"),
            Carta(Cor.RED, "R09"),
            Carta(Cor.RED, "R09"),
            Carta(Cor.RED, "R10"),
            Carta(Cor.RED, "R10"),
            Carta(Cor.RED, "R11"),
            Carta(Cor.RED, "R11"),
            Carta(Cor.RED, "R12"),
            Carta(Cor.RED, "R12"),
            Carta(Cor.RED, "R13"),
            Carta(Cor.YELLOW, "Y01"),
            Carta(Cor.YELLOW, "Y01"),
            Carta(Cor.YELLOW, "Y02"),
            Carta(Cor.YELLOW, "Y02"),
            Carta(Cor.YELLOW, "Y03"),
            Carta(Cor.YELLOW, "Y03"),
            Carta(Cor.YELLOW, "Y04"),
            Carta(Cor.YELLOW, "Y04"),
            Carta(Cor.YELLOW, "Y05"),
            Carta(Cor.YELLOW, "Y05"),
            Carta(Cor.YELLOW, "Y06"),
            Carta(Cor.YELLOW, "Y06"),
            Carta(Cor.YELLOW, "Y07"),
            Carta(Cor.YELLOW, "Y07"),
            Carta(Cor.YELLOW, "Y08"),
            Carta(Cor.YELLOW, "Y08"),
            Carta(Cor.YELLOW, "Y09"),
            Carta(Cor.YELLOW, "Y09"),
            Carta(Cor.YELLOW, "Y10"),
            Carta(Cor.YELLOW, "Y10"),
            Carta(Cor.YELLOW, "Y11"),
            Carta(Cor.YELLOW, "Y11"),
            Carta(Cor.YELLOW, "Y12"),
            Carta(Cor.YELLOW, "Y12"),
            Carta(Cor.YELLOW, "Y13"),
            Carta(Cor.YELLOW, "Y13"),
            Carta(Cor.YELLOW, "Y14"),
            Carta(Cor.YELLOW, "Y14"),
            Carta(Cor.YELLOW, "Y15"),
            Carta(Cor.YELLOW, "Y15"),
            Carta(Cor.YELLOW, "Y16"),
            Carta(Cor.YELLOW, "Y16"),
            Carta(Cor.YELLOW, "Y17"),
            Carta(Cor.YELLOW, "Y17"),
            Carta(Cor.YELLOW, "Y18"),
            Carta(Cor.YELLOW, "Y18"),
            Carta(Cor.YELLOW, "Y19"),
            Carta(Cor.YELLOW, "Y19"),
            Carta(Cor.YELLOW, "Y20"),
            Carta(Cor.YELLOW, "Y20"),
            Carta(Cor.YELLOW, "Y21"),
            Carta(Cor.YELLOW, "Y21"),
            Carta(Cor.YELLOW, "Y22"),
            Carta(Cor.YELLOW, "Y22"),
            Carta(Cor.YELLOW, "Y23"),
            Carta(Cor.YELLOW, "Y23"),
            Carta(Cor.YELLOW, "Y24"),
            Carta(Cor.YELLOW, "Y24")
        )
    }

}

private fun switchParticipante(
    rodada: Rodada,
    participante1: Participante,
    participante2: Participante
) {
    if (rodada.jogador == participante1) {
        rodada.jogador = participante2
    } else {
        rodada.jogador = participante1
    }
}

private fun clearRodada(rodada: Rodada) {
    if (rodada.primeiraCarta != null) {
        rodada.primeiraCarta!!.virada = false
    }
    if (rodada.segundaCarta != null) {
        rodada.segundaCarta!!.virada = false
    }

    rodada.primeiraCarta = null
    rodada.segundaCarta = null
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TabuleiroScreen(nomeParticipante1: String, nomeParticipante2: String, tamanhoTabuleiro: Int, onNavigate: (String) -> Unit) {
    val tabuleiroState = remember {
        mutableStateOf(Tabuleiro(tamanho = tamanhoTabuleiro).apply {
            val cartas = genarateLista(tamanhoTabuleiro).toMutableList()
            repeat(tamanhoTabuleiro) { cartas.shuffle() }
            matriz.addAll(cartas)
        })
    }


    val participante1 = remember { Participante(nomeParticipante1, 0, Cor.BLUE) }
    val participante2 = remember { Participante(nomeParticipante2, 0, Cor.RED) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val tabuleiro = tabuleiroState.value

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val horizontalPadding = 16.dp * 2
    val spacing = 4.dp * (tabuleiro.tamanho - 1)
    val availableWidth = screenWidth - horizontalPadding - spacing
    val buttonSize = availableWidth / tabuleiro.tamanho

    val rodada = Rodada(participante1)
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { _ ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Tabuleiro: ${tabuleiro.tamanho}X${tabuleiro.tamanho}",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Participante Azul: ${participante1.nome}: ${participante1.pontuacao} pontos",
                style = MaterialTheme.typography.bodyLarge,

            )
            Text(
                text = "Participante Vermelho: ${participante2.nome}: ${participante2.pontuacao} pontos",
                style = MaterialTheme.typography.bodyLarge
            )

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                maxItemsInEachRow = tabuleiro.tamanho
            ) {
                tabuleiro.matriz.forEachIndexed { index, carta ->
                    val color = when {
                        carta.virada -> when (carta.cor) {
                            Cor.BLACK -> ButtonDefaults.buttonColors(containerColor = Color.Black)
                            Cor.YELLOW -> ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                            Cor.BLUE -> ButtonDefaults.buttonColors(containerColor = Color.Blue)
                            Cor.RED -> ButtonDefaults.buttonColors(containerColor = Color.Red)
                            else -> ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                        }

                        else -> ButtonDefaults.buttonColors(containerColor = Color.DarkGray)
                    }

                    var labelButton =
                        "C${(index / tabuleiro.tamanho) + 1}${(index % tabuleiro.tamanho) + 1}"
                    if (carta.virada) {
                        labelButton = carta.valor
                    }

                    Button(
                        onClick = {
                            if (!carta.virada) {
                                if (rodada.primeiraCarta == null) {
                                    rodada.primeiraCarta = carta
                                    carta.virada = !carta.virada
                                } else if (rodada.segundaCarta == null) {
                                    rodada.segundaCarta = carta
                                    carta.virada = !carta.virada
                                }
                                if (rodada.primeiraCarta != null && rodada.segundaCarta != null) {
                                    if (rodada.primeiraCarta!!.valor != rodada.segundaCarta!!.valor) {
                                        scope.launch {
                                            if (rodada.primeiraCarta!!.cor == Cor.BLACK) {
                                                snackbarHostState.showSnackbar(
                                                    message = "ERROU! PERDEU A PARTIDA.",
                                                    duration = SnackbarDuration.Short
                                                )
                                                switchParticipante(
                                                    rodada,
                                                    participante1,
                                                    participante2
                                                )

                                                snackbarHostState.showSnackbar(
                                                    message = "PARTICIPANTE: ${rodada.jogador!!.nome} GANHOU A PARTIDA",
                                                    duration = SnackbarDuration.Short
                                                )
                                                delay(1000)

                                                onNavigate(Routes.MENU)

                                            } else if (rodada.primeiraCarta!!.cor != rodada.jogador!!.cor || rodada.segundaCarta!!.cor != rodada.jogador!!.cor) {
                                                rodada.jogador!!.pontuacao -= 2
                                                if (rodada.jogador!!.pontuacao >= 0) {
                                                    snackbarHostState.showSnackbar(
                                                        message = "ERROU! PERDEU 2 PONTOS. PASSOU A VEZ PARA OUTRA(O) PARTICIPANTE.",
                                                        duration = SnackbarDuration.Short
                                                    )
                                                    delay(1000) // Espera 3 segundos
                                                } else {
                                                    val pontuacao = rodada.jogador!!.pontuacao + 2
                                                    snackbarHostState.showSnackbar(
                                                        message = "ERROU! PERDEU $pontuacao PONTOS. PASSOU A VEZ PARA OUTRA(O) PARTICIPANTE.",
                                                        duration = SnackbarDuration.Short
                                                    )
                                                    delay(1000) // Espera 30 segundos

                                                    rodada.jogador!!.pontuacao = 0
                                                }
                                            } else {
                                                snackbarHostState.showSnackbar(
                                                    message = "ERROU! PASSOU A VEZ PARA OUTRA(O) PARTICIPANTE.",
                                                    duration = SnackbarDuration.Short
                                                )
                                                delay(1000)
                                            }

                                            clearRodada(rodada)
                                            switchParticipante(
                                                rodada,
                                                participante1,
                                                participante2
                                            )
                                        }
                                    } else {
                                        if (rodada.primeiraCarta!!.cor == Cor.YELLOW) {
                                            rodada.jogador!!.pontuacao += 1
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "ACERTOU! GANHOU 1 PONTOS. CONTINUE JOGANDO.",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        } else if (rodada.primeiraCarta!!.cor == Cor.BLACK) {
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "PARTICIPANTE: ${rodada.jogador!!.nome} GANHOU A PARTIDA",
                                                    duration = SnackbarDuration.Short
                                                )

                                                delay(1000);

                                                onNavigate(Routes.MENU);
                                            }

                                            onNavigate(Routes.MENU)
                                        } else if (rodada.primeiraCarta!!.cor == rodada.jogador!!.cor) {
                                            rodada.jogador!!.pontuacao += 5
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "ACERTOU! GANHOU 5 PONTOS. CONTINUE JOGANDO.",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        } else if (rodada.primeiraCarta!!.cor != rodada.jogador!!.cor) {
                                            rodada.jogador!!.pontuacao += 1
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "ACERTOU! GANHOU 1 PONTOS. CONTINUE JOGANDO.",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        }

                                        rodada.primeiraCarta = null
                                        rodada.segundaCarta = null
                                    }
                                }
                            }
                        },
                        modifier = Modifier.size(buttonSize),
                        shape = RoundedCornerShape(0.dp),
                        colors = color,
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = labelButton,
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }
    }
}


