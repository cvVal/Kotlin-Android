package com.apps.alo.ankolayouts

import com.apps.alo.ankolayouts.MainActivity
import com.apps.alo.ankolayouts.R
import org.jetbrains.anko.*

/**
 * Created by Severiano Valdez on 30/07/17.
 */
class LinearVertical : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        linearLayout {
            imageView(R.drawable.ic_launcher_background).lparams(width = dip(100), height = dip(100)){
                margin = dip(5)
            }

            verticalLayout {
                textView("textView1")
                textView("textView2")
            }
        }
    }
}