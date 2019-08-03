package seccioncinco

fun main(args: Array<String>) {

    val nums = 1..50

    for (elemento in nums) {
        println(elemento)
    }

    println("-------------------")

    for (elemento in nums step 5) {
        println(elemento)
    }

    println("-------------------")

    for (elemento in nums.reversed()) {
        println(elemento)
    }

    val nums2 = 1 until 15

    for (elementos in 15 downTo 1) {
        println(elementos)
    }

    for (elementos in 1 until 16) {
        println(elementos)
    }

    for (elemento in nums2) {
        println("El conteo es de ${nums2.count()} elementos")
    }

    var chars = 'A'..'z'

    for (elementos in chars) {
        println(elementos)
    }


}