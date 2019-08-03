package secciontres

fun main(args: Array<String>) {

    print("Ingresa el primer número")
    val num1 : Int = readLine()!!.toInt()

    print("Ingresa el segundo número")
    val num2 : Int = readLine()!!.toInt()

    val resultado = num1 / num2

    println("El resultado es $resultado")


}