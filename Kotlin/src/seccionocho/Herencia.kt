package seccionocho

open class Humano(){

    protected var palabra : String? = null

    fun saludo(){
        println("Hola a todos")
    }

}

class Perro() : Humano(){

    fun ladrido(){
        println("Guaauu, guaaaff")

    }

    fun getPalabra(){
        super.palabra
    }
}

class Gato(){

    fun maullido(){
        println("Miiiaaauuuuu")
    }
}

fun main(args: Array<String>) {

    var persona = Humano()
    var juanito = persona.saludo()

    var perrito = Perro()
    var coco = perrito.saludo()
}