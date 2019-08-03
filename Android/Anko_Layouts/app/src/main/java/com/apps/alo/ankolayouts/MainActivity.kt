package com.apps.alo.ankolayouts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.apps.alo.ankolayouts.VerticalLayout
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        VerticalLayout().setContentView(this)
    }
}
