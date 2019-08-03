package seccioncuatro

fun main(args: Array<String>) {

    print("¿Qué calificación obtuvo en variables?")
    var calVariables : Int = readLine()!!.toInt()

    print("¿Qué calificación obtuvo en operacionesMatematicas?")
    var calOperacionesMatematicas : Int = readLine()!!.toInt()

    print("¿Qué calificación obtuvo en operadoresLogicos?")
    var calOperadoresLogicos : Int = readLine()!!.toInt()

    print("¿Qué calificación obtuvo en condiciones?")
    var calCondiciones : Int = readLine()!!.toInt()

    var promedio = (calVariables + calOperacionesMatematicas + calOperadoresLogicos + calCondiciones) / 4

    if (promedio == 10) {
        println("Tu resultado es sobresaliente, Felicidades! Tu calificación es $promedio")
    } else if (promedio == 9) {
        println("Tu resultado es bueno. Tu calificación es $promedio")
    } else if (promedio >= 6 && promedio <= 8) {
        println("Tu resultado es suficiente. Tu calificación es $promedio")
    } else {
        println("Tu resultado es insuficiente. Tu calificación es $promedio")
    }

}
