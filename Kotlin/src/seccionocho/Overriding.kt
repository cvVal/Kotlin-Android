package seccionocho

open class Human(){

    open fun saludo(){
        println("Hola a todos")
    }

}

class Perr() : Human(){

    override fun saludo(){
        println("Soy un Perro, Hola a todos")
    }

    fun ladrido(){
        println("Guaauu, guaaaff")

    }

}

fun main(args: Array<String>) {

    var persona = Human()
    var juanito = persona.saludo()

    var perrito = Perr()
    var coco = perrito.saludo()
}