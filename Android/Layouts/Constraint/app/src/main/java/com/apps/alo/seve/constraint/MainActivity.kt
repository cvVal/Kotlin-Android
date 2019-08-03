package com.apps.alo.seve.constraint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var operacion = "*"
    var numeroPrevio = ""
    var nuevaOperacion = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun eventosBtn(view: View){

        if(nuevaOperacion){
            editTextNumeros.setText("")
        }
        nuevaOperacion= false

        val btnCliqueado = view as Button
        var valorDelBtn: String = editTextNumeros.text.toString()

        when (btnCliqueado.id){

            btnCero.id -> { valorDelBtn += "0"}
            btnUno.id -> { valorDelBtn += "1"}
            btnDos.id -> { valorDelBtn += "2"}
            btnTres.id -> { valorDelBtn += "3"}
            btnCuatro.id -> { valorDelBtn += "4"}
            btnCinco.id -> { valorDelBtn += "5"}
            btnSeis.id -> { valorDelBtn += "6"}
            btnSiete.id -> { valorDelBtn += "7"}
            btnOcho.id -> { valorDelBtn += "8"}
            btnNueve.id -> { valorDelBtn += "9"}
            btnPunto.id -> { valorDelBtn += "."}
            btnMasMenos.id -> { valorDelBtn = "-" + valorDelBtn}
        }
        editTextNumeros.setText(valorDelBtn)

    }

    fun operaciones(view: View) {

        val btnCliqueado = view as Button

        when (btnCliqueado.id) {

            btnDivision.id -> {
                operacion = "/"
            }
            btnMultiplicacion.id -> {
                operacion = "*"
            }
            btnResta.id -> {
                operacion = "-"
            }
            btnSuma.id -> {
                operacion = "+"
            }

        }

        numeroPrevio = editTextNumeros.text.toString()
        nuevaOperacion = true

    }

    fun resultado(view: View) {
        val nuevoNumero = editTextNumeros.text.toString()
        var numeroFinal:Double? = null

        when (operacion) {
            "*" -> numeroFinal = numeroPrevio.toDouble() * nuevoNumero.toDouble()

            "/" -> numeroFinal = numeroPrevio.toDouble() / nuevoNumero.toDouble()

            "+" -> numeroFinal = numeroPrevio.toDouble() + nuevoNumero.toDouble()

            "-" -> numeroFinal = numeroPrevio.toDouble() - nuevoNumero.toDouble()
        }

        editTextNumeros.setText(numeroFinal.toString())
        nuevaOperacion = true
    }

    fun porcentaje(view: View) {

        val numero:Double = editTextNumeros.text.toString().toDouble() / 100

        editTextNumeros.setText(numero.toString())
        nuevaOperacion = true
    }

    fun limpiar(view: View) {
        editTextNumeros.setText("0")
        nuevaOperacion = true
    }
}
