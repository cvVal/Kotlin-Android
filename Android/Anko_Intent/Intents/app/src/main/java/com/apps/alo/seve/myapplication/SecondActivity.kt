package com.apps.alo.seve.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.startActivity


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Flecha para regresar al Activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        val edad = bundle.getInt("edad")
        textViewIntent.text = edad.toString()

        btnToThirdActivity.setOnClickListener{
            startActivity<ThirdActivity>()
        }
    }
}