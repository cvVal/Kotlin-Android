package seccionocho

class Person(){

    var nombre: String? = null
    var edad: Int? = null
    var altura: Double? = null
    var peso: Double? = null
    var colorOjos: String? = null
    var genero: String? = null

    constructor(nombre: String, edad: Int, altura: Double, peso: Double,
                colorOjos: String, genero: String) : this() {

        this.nombre = nombre
        this.edad = edad
        this.altura = altura
        this.peso = peso
        this.colorOjos = colorOjos
        this.genero = genero
    }

    fun GetNombre(): String? {
        return this.nombre
    }
    fun GetGenero(): String?{
        return this.genero
    }

}


fun main(args: Array<String>) {

    var person = Person("Alondra", 36, 1.54, 50.0, "Cafes", "Mujer")
    println("El nombre es: " + person.GetNombre() + " y su género es " + person.GetGenero())

    var person2 = Person("Seve", 27, 1.70, 70.0, "Cafes", "Hombre")
    println("El nombre es: " + person2.GetNombre() + " y su género es " + person2.GetGenero())

}