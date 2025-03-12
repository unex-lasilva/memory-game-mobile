import kotlin.system.exitProcess

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    while (true) {
        println("1- INICIAR")
        println("2- PONTUAÇÃO PARTICIPANTES")
        println("3- REGRAS DO JOGO")
        println("4- SAIR ")

        val iniciar = readLine()!!.toInt()
        if (iniciar == 1) {
            iniciar()
        } else if (iniciar == 2) {
            pontuacao()
        } else if (iniciar == 3) {
            regras()
        } else if (iniciar == 4) {
            sair()
        } else {
            println("Digite uma opção válida")
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

            var opcaoTabuleiro = readLine()!!.toInt()

            when (opcaoTabuleiro) {
                1 -> tamanhoTabuleiro = 4
                2 -> tamanhoTabuleiro = 6
                3 -> tamanhoTabuleiro = 8
                4 -> tamanhoTabuleiro = 10
                else -> println("Digite um tamanho de tabuleiro válido.")
            }
        }
        println("Qual apelido do(a) participante 1?")
        var participante1 = readlnOrNull()!!.toString()
        if (participante1 == ""){
            participante1 = "PARTICIPANTE01"
        }
        println("Qual apelido do(a) participante 2?")
        var participante2 = readlnOrNull()!!.toString()
        if (participante2 == ""){
            participante2 = "PARTICIPANTE02"
        }
     print(participante1 + participante2)
    }

    fun pontuacao() {

    }

    fun regras() {
        println("Regras:")
    }

    fun sair() {
    exitProcess(0)
    }
