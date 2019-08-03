package com.apps.alo.ankolayouts

import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.EditText
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Severiano Valdez on 30/07/17.
 */

class VerticalLayout : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        verticalLayout {

            gravity = Gravity.CENTER

            scrollView {

                verticalLayout {

                    verticalLayout {
                        gravity = Gravity.CENTER
                        lparams(width = matchParent, height = matchParent) {

                            doFromSdk(version = Build.VERSION_CODES.JELLY_BEAN) {
                                background = ContextCompat.getDrawable(ctx, android.R.color.white)
                            }
                        }
                        padding = dip(20)

                        editText {
                            id = R.id.editTextUsuario
                            hint = "Usuario"
                        }.lparams(width = matchParent, height = wrapContent)


                        editText {
                            id = R.id.editTextPass
                            hint = "Password"
                        }.lparams(width = matchParent, height = wrapContent)

                        button {
                            id = R.id.btnLogin
                            textResource = R.string.btnLogin
                            onClick {

                            }
                        }.lparams(width = matchParent, height = wrapContent)

                    }.applyRecursively { view ->
                        when (view) {
                            is EditText -> view.textSize = 24f
                        }
                    }
                }
            }
        }
    }
}