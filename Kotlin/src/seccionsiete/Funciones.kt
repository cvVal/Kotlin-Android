package seccionsiete

fun suma(num1: Int, num2 : Int):Int{

    val suma = num1 + num2
    return suma
}
fun sinParametro():Unit{

    println("Hola, soy un método sin parámetros")

}

fun main(args: Array<String>) {

    val resultado = suma(1,5)

    println(resultado)

    sinParametro()

    val numerico: Int = -756

    println(numerico)

    println(Integer.MAX_VALUE)
    println(Double.MAX_VALUE)
    println(Float.MAX_VALUE)
    println(Short.MAX_VALUE)
    println(Byte.MAX_VALUE)
    println(Long.MAX_VALUE)

}
