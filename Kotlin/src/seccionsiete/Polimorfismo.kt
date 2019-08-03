package seccionsiete

fun polimorfismo(num1: Int):Unit {

    println("El número es $num1")

}

fun polimorfismo(num1: Double):Unit {

    println("El número es $num1")

}
fun polimorfismo(num1: Float):Unit {

    println("El número es $num1")

}
fun polimorfismo(nombre: String):Unit {

    println("El número es $nombre")

}


fun main(args: Array<String>) {

    polimorfismo(91239)
    polimorfismo(123.3458734)
    polimorfismo(12.345f)
    polimorfismo("Seve")


}
