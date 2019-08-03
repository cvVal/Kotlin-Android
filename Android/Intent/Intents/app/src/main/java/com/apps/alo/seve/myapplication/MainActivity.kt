package com.apps.alo.seve.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val SALUDO = "Hola desde el Activity main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Forzar el icono en el Action Bar
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setIcon(R.mipmap.ic_launcher)

        Toast.makeText(this, "Hola soy un Toast!!", Toast.LENGTH_SHORT).show()

        buttonCalcular.text = "Calcula tu edad"

        buttonCalcular.setOnClickListener {
            val añoNacimiento : Int = editText.text.toString().toInt()
            val añoActual = Calendar.getInstance().get(Calendar.YEAR)
            val miEdad = añoActual - añoNacimiento
            textView.text = "Tu edad es $miEdad años"
        }

        buttonSiguiente.setOnClickListener {
            startActivity(this, SecondActivity::class.java)
        }
    }

    fun startActivity(activity: Activity, nextActivity: Class<*>) {
        val intent = Intent(activity, nextActivity)
        intent.putExtra("saludo", SALUDO)
        activity.startActivity(intent)
    }

}
