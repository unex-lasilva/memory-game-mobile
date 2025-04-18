package com.mangarosa.game.navigation

object Routes {
    const val MENU = "menu"
    const val TABULEIRO_OPTION = "tabuleiroOption"
    const val PARTICIPANTE = "participante"
    const val TABULEIRO = "tabuleiro"

    fun tabuleiroRouteWithPlayers(p1: String, p2: String): String {
        return "$TABULEIRO/$p1/$p2"
    }
}