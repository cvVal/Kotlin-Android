package seccioncuatro

fun main(args: Array<String>) {

    val x = 16

    when (x) {

        1 -> {
            println("El valor es 1")
        }
        2 -> println("El valor es 2")
        3 -> println("El valor es 3")
        in 5..15 -> println("El valor está entre 5 y 15")
        !in 5..15 -> println("El valor no está entre 5 y 15")
        else -> println("El valor está fuera de rango")
    }

    val promedio = 8

    val resultado = when (promedio) {

        10 -> "Tu resultado es sobresaliente, Felicidades!!! Tu calificación es $promedio"
        9 -> "Tu resultado es bueno. Tu calificación es $promedio"
        6,7,8 -> "Tu resultado es suficiente. Tu calificación es $promedio"
        else ->"Tu resultado es insuficiente. Tu calificación es $promedio"
    }

    println(resultado)
}