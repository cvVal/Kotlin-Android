package seccionseis

fun main(args: Array<String>) {

    val nums = mutableListOf(0, 1, 2, -12, -24)

    nums[2] = 4

    for (elemento in nums) {
        println(elemento)
    }

    val inmutable = setOf(1, 2, 4, 0, 50, 50, 4)

    for (elemento in inmutable) {
        println(elemento)
    }

    val mutable = mutableSetOf(51, 2, 3, 23)

    mutable.add(40)

    for (elemento in mutable) {
        println(elemento)
    }

}