package com.mangarosa.game.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Carta(val cor: Cor, val valor: String) {
    var virada by mutableStateOf(false)
}