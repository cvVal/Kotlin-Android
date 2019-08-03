package seccioncuatro

fun main(args: Array<String>) {

    println("¿Cuál es el sueldo?")
    var sueldo : Double = readLine()!!.toDouble()

    if (sueldo > 1000) {

        println("Debe de pagar impuestos!!!!")
    }

}
