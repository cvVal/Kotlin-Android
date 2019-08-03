package seccionsiete

fun main(args: Array<String>) {

    val resultado = sumar(3,9)
    println(resultado)

    val result = summa(5,8)
    println(result)

    val resulta = maxx(150, 190)
    println(resulta)

}

fun sumar(a: Int, b: Int) : Int {
    return a+b
}

// In line Function
fun summa(a:Int, b: Int) : Int = a+b

fun maxim(num1: Int, num2: Int): Int {
    if (num1>num2)
        return num1
    else
        return num2
}
// In line Fuctions
fun maxx(num: Int, num2: Int) : Int = if (num>num2) num else num2