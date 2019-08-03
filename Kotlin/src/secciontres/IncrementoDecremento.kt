package secciontres

/*
1.- ()
2.- ++, -- (antes de la variable)
3.- ^
4.- *, /
5.- +, -
6.- % mod
7.- =
8.- ++,-- (después de la variable)
 */


fun main(args: Array<String>) {

    var num1 = 10
    val num2 = 5

    val resultado : Int?

    println(num1)
    resultado = ++num1 + num2

    println("El resultado es $resultado")
    println(num1)
}