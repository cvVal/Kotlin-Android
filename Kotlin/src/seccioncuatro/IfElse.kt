package seccioncuatro

fun main(args: Array<String>) {

    print("Ingresa primer valor:")
    var num1 : Int = readLine()!!.toInt()
    print("Ingresa segundo valor:")
    var num2 : Int = readLine()!!.toInt()

    if (num1 > num2) {

        println("El número mayor es $num1")

    } else {

        println("El número mayor es $num2")

    }

    var maximo = if ( num1 > num2) num1 else num2
    println("El valor máximo es: $maximo")

}
