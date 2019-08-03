package seccionocho

interface Operacion{

    abstract fun sum(num1: Int, num2: Int):Int
    fun div(num1: Int, num2: Int):Unit
    fun multiplicar(num1: Int, num2: Int):Int{
        return num1 * num2
    }


}

class Oper : Operacion{
    override fun sum(num1: Int, num2: Int): Int {
        return (num1 + num2) *3
    }

    override fun div(num1: Int, num2: Int) {
        println("La división es: " + num1/num2)

    }
}

fun main(args: Array<String>) {

    var operacion = Oper()
    var miOperacion = operacion.multiplicar(5,7)

    println(miOperacion)
}