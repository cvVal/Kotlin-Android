package secciondos

fun main(args: Array<String>) {

    var num1 : Int = 5
    var num3 : Int = 10
    var strgnumero : String = "19"

    num1 = strgnumero.toInt()

    println(num1)

    var num2 : Float? = 12.5f

    num2 = num3.toFloat()

    println(num2)

    var doble : Double

    doble = num3.toDouble()

    strgnumero = doble.toString()

}