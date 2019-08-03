package seccionseis

fun main(args: Array<String>) {

    val arrayList = ArrayList<String>()

    arrayList.add("Uva, ")
    arrayList.add("Kiwi, ")
    arrayList.add("Pitahaya")

    println("El elemento en la posición tres es: " + arrayList[2])

    print("Todos los elementos son: ")
    for (elemento in arrayList) {
        println(elemento)
    }
    println("Todos los elemento por índice son:")
    for (frutita in 0..2) {
        println(arrayList[frutita])
    }

    arrayList[1] = ("Fresa")
    arrayList.set(0, "Plátano")

    println(arrayList)

    if (arrayList.contains("Pithaya")) {
        println("Se ha encontrado")
    } else {
        println("no se ha encontrado")
    }

    for (tamañoDesconocido in 0..arrayList.size - 1) {
        println(arrayList[tamañoDesconocido])
    }
}
