package com.mangarosa.game.models

import androidx.compose.runtime.mutableStateListOf

class Tabuleiro(val tamanho: Int) {
    var matriz = mutableStateListOf<Carta>()
}