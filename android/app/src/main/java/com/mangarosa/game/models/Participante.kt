package com.mangarosa.game.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Participante(val nome: String, pontuacaoInicial: Int, val cor: Cor) {
    var pontuacao by mutableStateOf(pontuacaoInicial)


}
