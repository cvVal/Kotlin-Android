package seccioncinco

fun main(args: Array<String>) {

    /*for (elemento in 1..5){

        if(elemento == 3) {
            break
        }
        println(elemento)
    }*/

    loop@for (contador1 in 1..2) {

        for (contador2 in 1..5) {
            println("contador1: $contador1")
            if (contador2 == 2) {
                break@loop
            }
        }
    }

}