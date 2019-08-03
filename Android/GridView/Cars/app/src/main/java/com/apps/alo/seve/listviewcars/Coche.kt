package com.apps.alo.seve.listviewcars

/**
 * Created by Severiano Valdez on 24/07/2017.
 */

class Coche {

    var imagen : Int? = null
    var titulo : String? = null
    var descripcion : String? = null
    var precio : String? = null
    var venta : Boolean? = null

    constructor(imagen:Int, titulo:String, descripcion:String, precio:String, venta: Boolean){

        this.imagen = imagen
        this.titulo = titulo
        this. descripcion = descripcion
        this.precio = precio
        this.venta = venta

    }


}