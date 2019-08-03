package com.apps.alo.seve.listviewcars

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.molde_coche.view.*

class MainActivity(var adapter: CochesAdapter? = null ): AppCompatActivity() {

    var listaDeCoches = ArrayList<Coche>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaDeCoches.add(Coche(R.drawable.hw_bowser_sm, "Bowser", "Coche del malvado Bowser", "Precio: $350", false))
        listaDeCoches.add(Coche(R.drawable.hw_buddy_car,"Buddy", "Coche del vaquero buddy", "Precio: $350", true))
        listaDeCoches.add(Coche(R.drawable.hw_camaro_ee_2015,"Camaro", "Coche Camaro Edición Especial", "Precio: $350",  false))
        listaDeCoches.add(Coche(R.drawable.hw_charger_2014,"Charger", "Coche Charger 2014", "Precio: $350",  true))
        listaDeCoches.add(Coche(R.drawable.hw_fury_shark,"Shark", "Coche del temible tiburón", "Precio: $350",  false))
        listaDeCoches.add(Coche(R.drawable.hw_mario_sm,"Mario", "Coche de Super Mario", "Precio: $350",  false))
        listaDeCoches.add(Coche(R.drawable.hw_toad_sm,"Toad", "Coche de Toad", "Precio: $350",  true))
        listaDeCoches.add(Coche(R.drawable.hw_yoshi_sm,"Yoshi", "Coche de Yoshi", "Precio: $350",  true))

        adapter = CochesAdapter(this, listaDeCoches)
        listView.adapter = adapter
    }

    class CochesAdapter(contexto: Context, var listaDeCoches: ArrayList<Coche>): BaseAdapter(){

        var contexto:Context? = contexto

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            val coche = listaDeCoches[p0]
                if(coche.venta == true) {
                    val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val miVista = inflater.inflate(R.layout.molde_coche, null)
                    miVista.imageView.setImageResource(coche.imagen!!)
                    miVista.textViewTitulo.text = coche.titulo!!
                    miVista.textViewDescripcion.text = coche.descripcion!!
                    miVista.textViewPrecio.text = coche.precio!!
                    miVista.imageView.setOnClickListener {

                        val intent = Intent(contexto, CocheActivity::class.java)
                        intent.putExtra("imagen", coche.imagen!!)
                        intent.putExtra("titulo", coche.titulo!!)
                        intent.putExtra("descripcion", coche.descripcion!!)
                        intent.putExtra("precio", coche.precio!!)
                        contexto!!.startActivity(intent)
                    }
                    return miVista
                }else{
                    val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                    val miVista = inflater.inflate(R.layout.molde_venta, null)
                    miVista.imageView.setImageResource(coche.imagen!!)
                    miVista.textViewTitulo.text = coche.titulo!!
                    miVista.textViewDescripcion.text = coche.descripcion!!
                    miVista.textViewPrecio.text = coche.precio!!
                    miVista.imageView.setOnClickListener {

                        val intent = Intent(contexto, VentaActivity::class.java)
                        intent.putExtra("imagen", coche.imagen!!)
                        intent.putExtra("titulo", coche.titulo!!)
                        intent.putExtra("descripcion", coche.descripcion!!)
                        intent.putExtra("precio", coche.precio!!)
                        contexto!!.startActivity(intent)
                    }
                    return miVista
                }
        }

        override fun getItem(p0: Int): Any {
            return listaDeCoches[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return listaDeCoches.size
        }


    }
}
