package secciondos

fun main(args: Array<String>) {

    print("¿Cuál es tu nombre?")
    val nombre = readLine()
    print("¿Cuál es tu edad?")
    val edad : Int = readLine()!!.toInt()
    print("¿Cuál es tu fruta favorita?")
    val fruta : String?
    fruta = readLine()

    println("Tu nombre es: " + nombre)
    println("Tu edad es: "+ edad)
    println("Tu fruta favorita es: " + fruta)

}

