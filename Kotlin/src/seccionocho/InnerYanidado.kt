package seccionocho

class Externa{

    private val nombre: String? = null

    class Anidada{

        fun mostrar(){
            println("Soy una clase anidada")
        }
    }

}

fun main(args: Array<String>) {

    var externa = Externa()
    var anidada = Externa.Anidada()

    anidada.mostrar()

}