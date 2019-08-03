package com.apps.alo.sharedpreferences

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class LoginActivity : AppCompatActivity() {

    var preferencias : SharedPreferences?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolBar = find<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)

        //Modo en que se crea el archivo, si no se necesitan multiples Preferences usamos las Shared por defecto
        preferencias = PreferenceManager.getDefaultSharedPreferences(this)

        //Si se necesitan multiples preferences
        //preferencias = getSharedPreferences("Prefencias", Context.MODE_PRIVATE)

        ponerPrefSiExisten()

        btnLogin.onClick {
            val email = editTextEmail.text.toString()
            val pass = editTextPass.text.toString()

            if (logeo(email, pass)) {
                startActivity(intentFor<MainActivity>().newTask().clearTask())
                guardarPreferencias(email,pass)
            }
        }

    }

    fun validarEmail(email: String): Boolean {
        return !email.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validarPass(pass: String): Boolean {
        return pass.length >= 5
    }

    fun logeo(email: String, pass: String): Boolean {
        if (!validarEmail(email)) {
            toast("Email no valido, intenta nuevamente por favor")
            return false
        } else if (!validarPass(pass)) {
            toast("Password no valido, debe contener mínimo 5 carácteres")
            return false
        } else {
            return true
        }
    }

    fun guardarPreferencias(email: String, pass: String) {
        if (switchRecordar.isChecked) {
            preferencias!!.edit()
                    .putString("emal", editTextEmail.text.toString())
                    .putString("pass", editTextPass.text.toString())
                    .apply()
        }
    }

    fun ponerPrefSiExisten() {
        val email = preferencias!!.getString("emal", "")
        val pass = preferencias!!.getString("pass", "")
        if (!email.isNullOrEmpty() && !pass.isNullOrEmpty()) {
            editTextEmail.setText(email)
            editTextPass.setText(pass)
            switchRecordar.isChecked = true
        }
    }
}

