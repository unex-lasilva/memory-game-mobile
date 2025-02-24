package br.meujogo.models

class Jogador {

    fun pedirNomes(): Pair<String, String> {
        println("Digite o nome do Jogador 1: ")
        val jogador1 = readln()
        println("Digite o nome do Jogador 2: ")
        val jogador2 = readln()

        return Pair(jogador1, jogador2)
    }

}