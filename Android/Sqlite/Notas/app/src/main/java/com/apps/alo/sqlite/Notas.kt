package com.apps.alo.sqlite

/**
 * Created by Severiano Valdez on 27/07/17.
 */
class Notas{

    var notaID : Int?=null
    var titulo : String?=null
    var descripcion : String?=null

    constructor(notaID : Int,titulo : String,descripcion : String){

        this.notaID=notaID
        this.titulo=titulo
        this.descripcion=descripcion
    }

}