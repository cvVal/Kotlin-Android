package com.apps.alo.seve.tablelayout

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.github.johnpersano.supertoasts.library.Style
import com.github.johnpersano.supertoasts.library.SuperActivityToast
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils

class MainActivity : AppCompatActivity() {

    var jugador1 = ArrayList<Int>()
    var jugador2 = ArrayList<Int>()
    var jugadorActivo = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun btnCliqueado(view: View) {
        val btnSeleccionado = view as Button
        var idCelda = 0

        when (btnSeleccionado.id) {

            R.id.btn1 -> idCelda = 1
            R.id.btn2 -> idCelda = 2
            R.id.btn3 -> idCelda = 3
            R.id.btn4 -> idCelda = 4
            R.id.btn5 -> idCelda = 5
            R.id.btn6 -> idCelda = 6
            R.id.btn7 -> idCelda = 7
            R.id.btn8 -> idCelda = 8
            R.id.btn9 -> idCelda = 9
        }
        partida(idCelda, btnSeleccionado)
    }

    fun partida(idCelda: Int, btnSeleccionado: Button) {

        if (jugadorActivo == 1) {
            btnSeleccionado.text = "X"
            btnSeleccionado.setBackgroundColor(Color.BLUE)
            jugador1.add(idCelda)
            jugadorActivo = 2
        } else {
            btnSeleccionado.text = "O"
            btnSeleccionado.setBackgroundColor(Color.GREEN)
            jugador2.add(idCelda)
            jugadorActivo = 1

        }

        btnSeleccionado.isEnabled = false
        ganador()

    }

    fun ganador() {

        var ganador = -1

        //linea 1
        if (jugador1.contains(1) && jugador1.contains(2) && jugador1.contains(3)) {
            ganador = 1
        }
        if (jugador2.contains(1) && jugador2.contains(2) && jugador2.contains(3)) {
            ganador = 2
        }

        //linea2
        if (jugador1.contains(4) && jugador1.contains(5) && jugador1.contains(6)) {
            ganador = 1
        }
        if (jugador2.contains(4) && jugador2.contains(5) && jugador2.contains(6)) {
            ganador = 2
        }

        //linea3
        if (jugador1.contains(7) && jugador1.contains(8) && jugador1.contains(9)) {
            ganador = 1
        }
        if (jugador2.contains(7) && jugador2.contains(8) && jugador2.contains(9)) {
            ganador = 2
        }

        //columna1
        if (jugador1.contains(1) && jugador1.contains(4) && jugador1.contains(7)) {
            ganador = 1
        }
        if (jugador2.contains(1) && jugador2.contains(4) && jugador2.contains(7)) {
            ganador = 2
        }

        //columna2
        if (jugador1.contains(2) && jugador1.contains(5) && jugador1.contains(8)) {
            ganador = 1
        }
        if (jugador2.contains(2) && jugador2.contains(5) && jugador2.contains(8)) {
            ganador = 2
        }

        //columna3
        if (jugador1.contains(3) && jugador1.contains(6) && jugador1.contains(9)) {
            ganador = 1
        }
        if (jugador2.contains(3) && jugador2.contains(6) && jugador2.contains(9)) {
            ganador = 2
        }

        //linea en X 1
        if (jugador1.contains(1) && jugador1.contains(5) && jugador1.contains(9)) {
            ganador = 1
        }
        if (jugador2.contains(1) && jugador2.contains(5) && jugador2.contains(9)) {
            ganador = 2
        }

        //linea en X 2
        if (jugador1.contains(3) && jugador1.contains(5) && jugador1.contains(7)) {
            ganador = 1
        }
        if (jugador2.contains(3) && jugador2.contains(5) && jugador2.contains(7)) {
            ganador = 2
        }

        if (ganador != -1) {

            if (ganador == 1) {
                //Toast.makeText(this, "¡Jugador 1 ha ganado!", Toast.LENGTH_LONG).show()
                val superActivityToast = SuperActivityToast(this)
                superActivityToast.text = "!!!JUGADOR 1 HA GANADO!!!"
                superActivityToast.duration = Style.DURATION_LONG
                superActivityToast.color = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_CYAN)
                superActivityToast.textColor = Color.BLACK
                superActivityToast.setTouchToDismiss(true)
                superActivityToast.isIndeterminate = true
                superActivityToast.progressIndeterminate = true
                superActivityToast.show()
            } else {
                //Toast.makeText(this, "¡Jugador 2 ha ganado!", Toast.LENGTH_LONG).show()
                val superActivityToast = SuperActivityToast(this)
                superActivityToast.text = "!!!JUGADOR 2 HA GANADO!!!"
                superActivityToast.duration = Style.DURATION_LONG
                superActivityToast.color = PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_CYAN)
                superActivityToast.textColor = Color.BLACK
                superActivityToast.setTouchToDismiss(true)
                superActivityToast.isIndeterminate = true
                superActivityToast.progressIndeterminate = true
                superActivityToast.show()
            }
        }
    }

}