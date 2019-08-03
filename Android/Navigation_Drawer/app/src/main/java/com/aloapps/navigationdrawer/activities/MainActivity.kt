package com.aloapps.navigationdrawer.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.aloapps.navigationdrawer.R
import com.aloapps.navigationdrawer.fragments.EmailFragment
import com.aloapps.navigationdrawer.fragments.FotosFragment
import com.aloapps.navigationdrawer.fragments.PerfilFragment


class MainActivity : AppCompatActivity() {

    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigationView)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_hamburguesa)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        cambiarFragmento(PerfilFragment(), navigationView!!.menu.getItem(0))

        drawerLayout!!.addDrawerListener(object : DrawerLayout.DrawerListener {

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

            }

            override fun onDrawerOpened(drawerView: View) {
                Toast.makeText(this@MainActivity, "Open", Toast.LENGTH_SHORT).show()
            }

            override fun onDrawerClosed(drawerView: View) {
                Toast.makeText(this@MainActivity, "Close", Toast.LENGTH_SHORT).show()
            }

            override fun onDrawerStateChanged(newState: Int) {

            }
        })

        navigationView!!.setNavigationItemSelectedListener { item ->

            var gestorDeFragmentos = false
            var fragment: Fragment? = null

            when(item.itemId){

                R.id.menu_perfil ->{
                    fragment = PerfilFragment()
                    gestorDeFragmentos = true
                }
                R.id.menu_fotos ->{
                    fragment = FotosFragment()
                    gestorDeFragmentos = true
                }
                R.id.menu_mail ->{
                    fragment = EmailFragment()
                    gestorDeFragmentos = true
                }
                R.id.menu_borrar ->{
                    Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_ayuda ->{
                    Toast.makeText(this, "Ayuda", Toast.LENGTH_SHORT).show()
                }

            }

            if (gestorDeFragmentos){
                cambiarFragmento(fragment, item)
                drawerLayout!!.closeDrawers()
            }

            true
        }

    }

    fun cambiarFragmento(fragment: Fragment?, item: MenuItem){
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit()
        item.isChecked = true
        supportActionBar!!.title = item.title
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item!!.itemId){
            android.R.id.home -> {

                drawerLayout!!.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
