package secciondos

fun main(args: Array<String>) {


    println("¿Cuál es tu nombre?")
    val nombre = readLine()

    println(nombre)

    println("¿Cuál es tu edad?")
    val edad : Int = readLine()!!.toInt()

    println(edad)

}