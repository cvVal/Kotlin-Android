package seccionocho

enum class Meses{

    ENE, FEB, MAR, ABR, MAY, JUN, JUL, AGO, SEP, OCT, NOV, DIC

}

fun main(args: Array<String>) {

    var sextoMes = Meses.JUN
    var primerMes = Meses.ENE

    println("Nombre: " + sextoMes.name)
    println("Posición:" + sextoMes.ordinal)
    println("Posición:" + primerMes.ordinal)
    println("Comparar: " + sextoMes.compareTo(primerMes))
    println("Comparar: " + primerMes.compareTo(sextoMes))

    println("Inicia For")

    for(item in Meses.values()){
        println(item)
    }

}