package seccioncuatro

fun main(args: Array<String>) {

    print("Ingresa la medida en metros:")
    var medida : Double = readLine()!!.toDouble()

    if (medida >= 1.00) {

        if (medida > 5.0) {
            println("La medida $medida sobrepasa los límites aceptados")
        } else {
            println("La medida $medida es aceptable")
        }
    } else {
        println(" Lo siento, la medida $medida No es aceptable")
    }

}
