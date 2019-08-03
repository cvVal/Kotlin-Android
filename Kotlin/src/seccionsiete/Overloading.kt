package seccionsiete

fun sum(num1: Int, num2 : Int):Int{

    val suma = num1 + num2
    return suma
}

fun sum(num1: Int, num2 : Int, num3 : Int):Int{

    val suma = num1 + num2 + num3
    return suma
}
fun sum(num1: Int, num2 : Int, num3 : Int, num4 : Int):Int{

    val suma = num1 + num2 + num3 + num4
    return suma
}



fun main(args: Array<String>) {

    var resultado = sum(5,7)
    println(resultado)

    resultado = sum(6,9,15)
    println(resultado)

    resultado = sum(7, 9, 4, 8)
    println(resultado)




}
