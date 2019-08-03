package com.aloapps.alarmapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gDatos = GuardarDatos(applicationContext)
        textViewHora.text = gDatos.obtenerHora().toString() + ":" + gDatos.obtenerMinutos().toString()

        btnOK.setOnClickListener {
            val tiempo = TimePicker()
            val fragmentManager = fragmentManager

            tiempo.show(fragmentManager, "Selecciona una hora")
        }
    }

    fun setearHora(hora: Int, minutos: Int) {
        textViewHora.text = hora.toString() + ":" + minutos.toString()

        val guardarDatos = GuardarDatos(applicationContext)
        guardarDatos.sharedPrefs(hora, minutos)
        guardarDatos.programarAlarma()

    }
}
