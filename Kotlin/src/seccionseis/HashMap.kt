package seccionseis

fun main(args: Array<String>) {

    val hashMap = HashMap<Int, String>()
    //Key VAlue
    hashMap.put(1, "Merida")
    hashMap.put(200, "Villahermosa")
    hashMap.put(0, "Izamal")
    hashMap.put(50, "Seve")
    println(hashMap[200])

    hashMap.put(50, "Seve Valdez")

    for (clave in hashMap.keys) {
        println(hashMap[clave])
    }

}
