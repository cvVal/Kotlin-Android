package com.apps.alo.seve.listviewcars

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Severiano Valdez on 24/07/2017.
 */

class MainActivity(var adapter: CocheAdapter? = null) : AppCompatActivity() {

    var listaDeCoches = ArrayList<Coche>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaDeCoches.add(Coche(R.drawable.hw_bowser_sm, "Bowser", "Coche del malvado Bowser", "Precio: $350", false))
        listaDeCoches.add(Coche(R.drawable.hw_buddy_car, "Buddy", "Coche del vaquero buddy", "Precio: $350", true))
        listaDeCoches.add(Coche(R.drawable.hw_camaro_ee_2015, "Camaro", "Coche Camaro Edición Especial", "Precio: $350", false))
        listaDeCoches.add(Coche(R.drawable.hw_charger_2014, "Charger", "Coche Charger Edición 2014", "Precio: $350", true))
        listaDeCoches.add(Coche(R.drawable.hw_fury_shark, "Shark", "Coche del temible tiburón", "Precio: $350", false))
        listaDeCoches.add(Coche(R.drawable.hw_mario_sm, "Mario", "Coche de Super Mario Bro", "Precio: $350", false))
        listaDeCoches.add(Coche(R.drawable.hw_toad_sm, "Toad", "Coche de Super Toad Bro", "Precio: $350", true))
        listaDeCoches.add(Coche(R.drawable.hw_yoshi_sm, "Yoshi", "Coche de Super Yoshi Bro", "Precio: $350", true))

        adapter = CocheAdapter(this, listaDeCoches)
        gridView.adapter = adapter
    }
}
