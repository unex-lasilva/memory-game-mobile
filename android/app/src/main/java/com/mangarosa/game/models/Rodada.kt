package com.mangarosa.game.models

class Rodada(var jogador: Participante?) {
    var primeiraLinha: Int = 0
    var primeiraColuna: Int = 0
    var segundaLinha: Int = 0
    var segundaColuna: Int = 0
    var tentativa: Int = 0
    var primeiraCarta: Carta? = null
    var segundaCarta: Carta? = null
}
