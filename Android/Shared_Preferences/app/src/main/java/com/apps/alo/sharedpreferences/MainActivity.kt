package com.apps.alo.sharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    var toolBarColaps: CollapsingToolbarLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolBarColaps = findViewById(R.id.collapsing_toolbar)
        toolBarColaps!!.title = "Beneficios Kotlin"

        val toolBar = find<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item!!.itemId) {

        R.id.menuSalir ->{
            startActivity(intentFor<LoginActivity>().newTask().clearTask())
            true
        }
        R.id.menuOlvidar ->{
            defaultSharedPreferences.edit().clear().apply()
            startActivity(intentFor<LoginActivity>().newTask().clearTask())
            true
        }

       else ->false
    }

}
