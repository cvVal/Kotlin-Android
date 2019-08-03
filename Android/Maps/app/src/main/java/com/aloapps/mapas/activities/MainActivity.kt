package com.aloapps.mapas.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import com.aloapps.mapas.R
import com.aloapps.mapas.fragments.MainFragment
import com.aloapps.mapas.fragments.MapsFragment
import com.aloapps.mapas.fragments.MapsGpsFragment
import com.google.android.gms.maps.MapFragment

class MainActivity : AppCompatActivity() {

    var fragmentoActual: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentoActual = MainFragment()
        cambiarFragmento(fragmentoActual)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){
            R.id.menu_principal -> fragmentoActual = MainFragment()
            R.id.menu_mapa -> fragmentoActual = MapsFragment()
            R.id.menu_mapa_gps -> fragmentoActual = MapsGpsFragment()
        }
        cambiarFragmento(fragmentoActual)
        return super.onOptionsItemSelected(item)
    }

    fun cambiarFragmento(fragment: Fragment?){
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }
}
