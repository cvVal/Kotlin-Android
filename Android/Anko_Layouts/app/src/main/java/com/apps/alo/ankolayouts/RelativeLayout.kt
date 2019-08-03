package com.apps.alo.ankolayouts

import android.view.View
import org.jetbrains.anko.*

class RelativeLayout : AnkoComponent<MainActivity> {


    override fun createView(ui: AnkoContext<MainActivity>) = ui.apply{

        val btnCentro = 1
        val btnArriba = 2
        relativeLayout{
            button("Centro"){
                id = btnCentro
            }.lparams(width = wrapContent){
                centerHorizontally()
                centerVertically()
            }

            button("Arriba"){
                id = btnArriba
            }.lparams(width = wrapContent){
                above(btnCentro)
                alignStart(btnCentro)
            }

            button("derecha").lparams{
                below(btnArriba)
                rightOf(btnArriba)
            }

            button("izquierda").lparams{
                leftOf(btnCentro)
                below(btnArriba)
            }

            button("abajo").lparams{
                alignEnd(btnCentro)
                below(btnCentro)
            }

            button("Superior").lparams{
                alignParentTop()
                alignParentEnd()

            }
        }

    }.view


}