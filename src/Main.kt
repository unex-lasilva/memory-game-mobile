//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
  println("Tamanho tab: \n1 = (4x4)\n2 = (6x6)\n3 = (8x8)\n4 = (10x10)\n Opção: ")
  val tamanho = readln().toInt()

  when(tamanho){
    1 -> println("4x4")
    2 -> println("6x6")
    3 -> println("8x8")
    4 -> println("10x10")
    else -> println("erro")
  }
}