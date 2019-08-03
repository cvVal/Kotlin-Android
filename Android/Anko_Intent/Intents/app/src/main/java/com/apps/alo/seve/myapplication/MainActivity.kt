package com.apps.alo.seve.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Forzar el icono en el Action Bar
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)

        //Toast.makeText(this, "Hola soy un Toast!!", Toast.LENGTH_SHORT).show()
        longToast(getString(R.string.main_longtoast))

        buttonCalcular.setOnClickListener {
            val añoNacimiento: Int = editText.text.toString().toInt()
            val añoActual = Calendar.getInstance().get(Calendar.YEAR)
            val miEdad = añoActual - añoNacimiento

            startActivity<SecondActivity>("edad" to miEdad)
        }
        btnAnko.onClick {
            alert(getString(R.string.main_alert_mensaje), getString(R.string.main_alert_titulo)){
                yesButton { longToast(getString(R.string.main_alert_btn_positivo)) }
                noButton { toast(getString(R.string.main_alert_btn_negtivo)) }
            }.show()
        }

        btnLista.onClick {
            val paises = listOf("MEX", "ESP", "ARG", "BOL", "CHL", "COL")
            selector(getString(R.string.main_alert_lista), paises, { dialogInterface, i ->
                longToast("Genial!, entonces vives en" + paises[i] + "cierto?") })
        }

        btnProgreso.onClick {
            progressDialog(message = getString(R.string.main_alert_progreso_mensaje), title = getString(R.string.main_alert_progreso_titulo))
        }
    }
}