package com.apps.alo.ankolayouts

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Severiano Valdez on 30/07/17.
 */
class MiLayout : AnkoComponent<MainActivity>{

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            var nombre = editText{
                hint = "Cual es tu nombre? "
                textSize = 15f
            }
            button("presioname"){
                textSize = 25f
                onClick { longToast("Hola, ${nombre.text}!!") }
            }
            button("Botón").lparams(width = wrapContent){
                verticalMargin = dip(50)
                horizontalMargin = dip(50)
            }

            button()
        }
    }

}