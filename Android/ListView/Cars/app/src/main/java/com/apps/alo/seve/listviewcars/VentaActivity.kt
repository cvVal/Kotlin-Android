package com.apps.alo.seve.listviewcars

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.molde_coche.*

class VentaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta)

        val bundle: Bundle = intent.extras
        val imagen = bundle.getInt("imagen")
        val titulo = bundle.getString("titulo")
        val descripcion = bundle.getString("descripcion")
        val precio = bundle.getString("precio")
        imageView.setImageResource(imagen)
        textViewTitulo.text = titulo
        textViewDescripcion.text = descripcion
        textViewPrecio.text = precio
    }
}
