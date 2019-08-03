package com.apps.alo.seve.listviewcars

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_coche.view.*

/**
 * Created by Severiano Valdez on 24/07/2017.
 */

class CocheAdapter(contexto: Context, var listaDeCoches: ArrayList<Coche>): BaseAdapter() {

    var contexto: Context? = contexto

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val coche = listaDeCoches[p0]
        if (coche.venta == true) {
            val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val miVista = inflater.inflate(R.layout.molde_coche_grid, null)
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
        } else {
            val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val miVista = inflater.inflate(R.layout.molde_venta_grid, null)
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