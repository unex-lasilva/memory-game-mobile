package com.mangarosa.game.navigation

object Routes {
    const val MENU = "menu"
    const val TABULEIRO_OPTION = "tabuleiroOption"
    const val PARTICIPANTE = "participante"
    const val TABULEIRO = "tabuleiro"

    fun tabuleiroRouteWithPlayers(p1: String, p2: String, tamanho : Int): String {
        return "$TABULEIRO/$p1/$p2/$tamanho"
    }

    fun tabuleiroOptinSize(tamanho : Int): String {
        return "$PARTICIPANTE/$tamanho"
    }
}