import kotlin.system.exitProcess

fun main() {
    println()

    while (true) {
        println("1- INICIAR")
        println("2- PONTUAÇÃO PARTICIPANTES")
        println("3- REGRAS DO JOGO")
        println("4- SAIR ")


        val opcao = readln().toInt()
        when (opcao) {
            1 -> iniciar()
            2 -> pontuacao()
            3 -> regras()
            4 -> sair()
            else -> println("Digite uma opção válida")
        }
    }
}

fun iniciar() {
    var tamanhoTabuleiro = 0
    while (tamanhoTabuleiro == 0) {
        println("DIGITE O TAMANHO DO TABULEIRO:")
        println("1- 4X4")
        println("2- 6X6")
        println("3- 8x8")
        println("4- 10x10")

        val opcaoTabuleiro = readln().toInt()

        when (opcaoTabuleiro) {
            1 -> tamanhoTabuleiro = 4
            2 -> tamanhoTabuleiro = 6
            3 -> tamanhoTabuleiro = 8
            4 -> tamanhoTabuleiro = 10
            else -> println("Digite um tamanho de tabuleiro válido.")
        }


    }

    println("Qual apelido do(a) participante 1?")
    var nomeParticpante1 = readlnOrNull()!!.toString()
    if (nomeParticpante1 == "") {
        nomeParticpante1 = "PARTICIPANTE01"
    }
    val participante1: Participante = Participante(nomeParticpante1, 0, Cor.RED)

    println("Qual apelido do(a) participante 2?")
    var nomeParticpante2 = readlnOrNull()!!.toString()
    if (nomeParticpante2 == "") {
        nomeParticpante2 = "PARTICIPANTE02"
    }

    val participante2: Participante = Participante(nomeParticpante2, 0, Cor.BLUE)
    print(participante1.nome + participante2.nome)

    jogar(Tabuleiro(tamanhoTabuleiro), participante1, participante2)

}

fun pontuacao() {

}

fun regras() {
    //JOSÉ IMPLEMENTAR
    // AQUI TU VAI PRINTAR AS REGRAS, PEGA ELA DO PDF QUE TA NO BLACKBOARD
    println("Regras:")
}

fun sair() {
    exitProcess(0)
}

fun jogar(tabuleiro: Tabuleiro, participante1: Participante, participante2: Participante) {

    val lista = genarateLista(tabuleiro.tamanho)


    for (i in 1..<tabuleiro.tamanho) {
        lista.shuffle()
    }

    tabuleiro.matriz = Array(tabuleiro.tamanho) { Array(tabuleiro.tamanho) { Carta(Cor.NONE, "") } }

    var index = 0

    for (i in 0..<tabuleiro.tamanho) {
        for (j in 0..<tabuleiro.tamanho) {
            if (index < lista.size) {
                tabuleiro.matriz!![i][j] = lista[index]
                index++
            }
        }
    }

    val rodada = Rodada(participante1)
    while (true) {
        println()
        println("=============================================================================")
        println("\u001B[31m ${participante1.cor}\u001B[0m ${participante1.nome} - ${participante1.pontucao} pontos  / \u001B[34m ${participante2.cor}\u001B[0m ${participante2.nome} - ${participante2.pontucao} pontos")
        printTabuleiro(tabuleiro)

        try {
            rodada.primeiraCarta = selecionarCarta(rodada, tabuleiro)
            rodada.segundaCarta = selecionarCarta(rodada, tabuleiro)
        } catch (e: Exception) {
            clearRodada(rodada)
            switchParticipante(rodada, participante1, participante2)
            continue
        }


        if (rodada.primeiraCarta!!.valor != rodada.segundaCarta!!.valor) {
            if (rodada.primeiraCarta!!.cor == Cor.BLACK) {
                println("ERROU! PERDEU A PARTIDA.")
                switchParticipante(rodada, participante1, participante2)
                println("PARTICIPANTE: ${rodada.jogador!!.nome} GANHOU A PARTIDA")
                break
            } else if (rodada.primeiraCarta!!.cor != rodada.jogador!!.cor || rodada.segundaCarta!!.cor != rodada.jogador!!.cor) {
                rodada.jogador!!.pontucao -= 2
                if (rodada.jogador!!.pontucao >= 0) {
                    println("ERROU! PERDEU 2 PONTOS. PASSOU A VEZ PARA OUTRA(O) PARTICIPANTE.")
                } else {
                    println("ERROU! PERDEU ${rodada.jogador!!.pontucao + 2} PONTOS. PASSOU A VEZ PARA OUTRA(O) PARTICIPANTE.")
                    rodada.jogador!!.pontucao = 0
                }
            } else {
                println("ERROU! PASSOU A VEZ PARA OUTRA(O) PARTICIPANTE.")
            }

            clearRodada(rodada)
            switchParticipante(rodada, participante1, participante2)
        } else {
            if (rodada.primeiraCarta!!.cor == Cor.YELLOW) {
                rodada.jogador!!.pontucao += 1
                println("ACERTOU! GANHOU 1 PONTOS. CONTINUE JOGANDO.")
            } else if (rodada.primeiraCarta!!.cor == Cor.BLACK) {
                println("PARTICIPANTE: ${rodada.jogador!!.nome} GANHOU A PARTIDA")
                break
            } else if (rodada.primeiraCarta!!.cor == rodada.jogador!!.cor) {
                rodada.jogador!!.pontucao += 5
                println("ACERTOU! GANHOU 5 PONTOS. CONTINUE JOGANDO.")
            } else if (rodada.primeiraCarta!!.cor != rodada.jogador!!.cor) {
                rodada.jogador!!.pontucao += 1
                println("ACERTOU! GANHOU 1 PONTOS. CONTINUE JOGANDO.")
            }
        }

        rodada.primeiraCarta = null
        rodada.segundaCarta = null
    }
}

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
            // AQUI TU VAI PEGAR LOGICA DO CÓDIGO DE CIMA, NO PDF TEM EXPLICANDO COMO É A LOGICA DAS CARTAS
            //JOSÉ IMPLEMENTAR
        )

        8 -> arrayOf(
            //JOSÉ IMPLEMENTAR
        )
        // Caso tamanho seja 10
        else -> arrayOf(
            //JOSÉ IMPLEMENTAR
        )
    }

}


private fun selecionarCarta(rodada: Rodada, tabuleiro: Tabuleiro): Carta {
    var carta: Carta? = null

    var escolha = Escolha.FIRST
    if (rodada.primeiraCarta != null) {
        escolha = Escolha.SECOND
    }

    rodada.tentativa = 0
    println()
    println("Participante: ${rodada.jogador!!.nome}")
    println("DIGITE A POSIÇÃO DA ${escolha.nome} CARTA QUE DESEJA REVELAR:")
    while (carta == null) {

        print("Linha: ")
        val linha = readln().toInt()

        print("Coluna: ")
        val coluna = readln().toInt()

        try {
            carta = validaCarta(linha, coluna, tabuleiro)
            if (escolha == Escolha.FIRST) {
                rodada.primeiraLinha = linha
                rodada.primeiraColuna = coluna
            } else {
                rodada.segundaLinha = linha
                rodada.segundaColuna = coluna
            }
        } catch (e: Exception) {
            rodada.tentativa++
            println(e.message)
        }
        printTabuleiro(tabuleiro)

        if (rodada.tentativa >= 3) {
            break
        }
    }

    if (rodada.tentativa >= 3) {
        throw Exception("PASSOU A VEZ PARA OUTRA(O) PARTICIPANTE.")
    }

    return carta!!
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

private fun switchParticipante(rodada: Rodada, participante1: Participante, participante2: Participante) {
    if (rodada.jogador == participante1) {
        rodada.jogador = participante2
    } else {
        rodada.jogador = participante1
    }
}

private fun validaCarta(linha: Int, coluna: Int, tabuleiro: Tabuleiro): Carta {
    if (linha > tabuleiro.tamanho || linha < 1) {
        throw Exception("Posição da carta inválida, por favor, insira uma posição válida")
    }

    if (coluna > tabuleiro.tamanho || coluna < 1) {
        throw Exception("Posição da carta inválida, por favor, insira uma posição válida")
    }

    val carta = tabuleiro.matriz!![linha - 1][coluna - 1]
    if (carta.virada) {
        throw Exception("A carta da posição informada já está virada, por favor, escolha outra posição")
    }

    carta.virada = true
    return carta
}

fun printTabuleiro(tabuleiro: Tabuleiro) {
    var textoPrint = "   1    2    3    4\n"
    for (i in 0..<tabuleiro.tamanho) {
        textoPrint += "${i + 1}"
        for (j in 0..<tabuleiro.tamanho) {
            if (tabuleiro.matriz!![i][j].virada) {
                val color = when (tabuleiro.matriz!![i][j].cor) {
                    Cor.BLACK -> "\u001b[30m"
                    Cor.YELLOW -> "\u001b[33m"
                    Cor.BLUE -> "\u001b[34m"
                    Cor.RED -> "\u001b[31m"
                    Cor.NONE -> "\u001B[0m"
                }

                textoPrint += "$color ${tabuleiro.matriz!![i][j].valor} \u001b[0m"
            } else {
                textoPrint += " C${i + 1}${j + 1} "
            }
        }
        textoPrint += "\n"
    }
    println()
    print(textoPrint)
}


class Rodada(var jogador: Participante?) {
    var primeiraLinha: Int = 0
    var primeiraColuna: Int = 0
    var segundaLinha: Int = 0
    var segundaColuna: Int = 0
    var tentativa: Int = 0
    var primeiraCarta: Carta? = null
    var segundaCarta: Carta? = null
}

class Tabuleiro(val tamanho: Int) {
    var matriz: Array<Array<Carta>>? = null
}

class Carta(val cor: Cor, val valor: String) {
    var virada: Boolean = false
}

class Participante(val nome: String, var pontucao: Int, val cor: Cor)

enum class Cor {
    BLUE, RED, BLACK, YELLOW, NONE
}

enum class Escolha(val nome: String) {
    FIRST("PRIMEIRA"), SECOND("SEGUNDA")
}