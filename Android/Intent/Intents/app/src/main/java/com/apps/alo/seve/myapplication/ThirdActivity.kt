package com.apps.alo.seve.myapplication

import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_third.*
import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {

    private val PHONE_CODE = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        //Flecha para regresar al Activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // --- Botón para la llamada --- //
        imageButtonPhone!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val phoneNumber = editTextPhone!!.text.toString()
                if(!phoneNumber.isEmpty()){
                    // --- Comprobar versión actual VS version MarshMallow + --- //
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        // --- Comprobar el permiso --- //
                        if (ChecarPermiso(Manifest.permission.CALL_PHONE)) {
                            // --- Si está el permiso en el manifst ha aceptado --- //
                            val intentAceptado = Intent(Intent.ACTION_CALL, Uri.parse("{tel:$phoneNumber}"))
                            if (ActivityCompat.checkSelfPermission(this@ThirdActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                return
                            }
                            startActivity(intentAceptado)
                        }else{  // --- Preguntarle por el permiso --- //
                            if (!shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                                requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), PHONE_CODE)
                            }else{
                                /* --- Si ya denegó el permiso y quiere acceder nuevamente
                                        lo dirijimos a los Ajustes para que habilite el permiso --- */
                                Toast.makeText(this@ThirdActivity, "Por favor habilita el permiso correspondiente para continuar", Toast.LENGTH_LONG).show()
                                val intentSetting = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                intentSetting.addCategory(Intent.CATEGORY_DEFAULT)
                                intentSetting.data = Uri.parse("package:" + packageName)
                                intentSetting.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                intentSetting.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                                intentSetting.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                                startActivity(intentSetting)
                            }
                        }
                    }else {
                        versionAntigua(phoneNumber)
                    }
                } else{
                    Toast.makeText(this@ThirdActivity, "Debes marcar un número, intenta nuevamente", Toast.LENGTH_LONG).show()
                }
            }

            fun versionAntigua(phoneNumber: String) {
                val intentCall = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber))
                if (ChecarPermiso(Manifest.permission.CALL_PHONE)) {
                    if (ActivityCompat.checkSelfPermission(this@ThirdActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return
                    }
                    startActivity(intentCall)
                }
            }
        })

        // --- Botón para la Web --- //
        imageButtonWeb!!.setOnClickListener {
            val url = editTextWeb!!.text.toString()

            val intentWeb = Intent()
            intentWeb.action = Intent.ACTION_VIEW
            intentWeb.data = Uri.parse("http://" + url)
            startActivity(intentWeb)
        }

        // --- Botón para el correo --- //
        buttonEmailMe!!.setOnClickListener {

            val email = "miemail@gmail.com"

            val intentEmail = Intent(Intent.ACTION_SEND, Uri.parse(email))
            intentEmail.type = "plain/text"
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Título del email")
            intentEmail.putExtra(Intent.EXTRA_TEXT, "Hola, estoy esperando la respuesta...")
            intentEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("alguien@gmail.com", "alguienmas@gmail.com"))
            startActivity(Intent.createChooser(intentEmail, "Elige cliente de correo"))
        }

        // --- Botón para la llamada sin permisos --- //
        buttonContactPhone!!.setOnClickListener {
            val intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9999299229"))
            startActivity(intentCall)
        }

        // --- Botón para la cámara --- //
        imageButtonCamera!!.setOnClickListener {
            val intentCamera = Intent("android.media.action.IMAGE_CAPTURE")
            startActivity(intentCamera)
        }


    }

    // --- Inflamos la vista de nuestro menú --- //
    override fun onCreateOptionsMenu(menu : Menu):Boolean{
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // --- Creamos la lógica según la opción que el usuario seleccione --- //
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            R.id.menuContactos ->{
                val intentContactos = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"))
                startActivity(intentContactos)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // --- Método asíncrono para comprobar permisos --- //
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            //Caso de uso
            PHONE_CODE ->{

                val permiso = permissions[0]
                val resultado = grantResults[0]

                if (permiso == Manifest.permission.CALL_PHONE) {
                    // --- Comprobar si ha sido aceptado o denegado la petición de permiso --- //
                    if (resultado == PackageManager.PERMISSION_GRANTED) {
                        // --- Concedió su permiso --- //
                        val phoneNumber = editTextPhone!!.text.toString()
                        val intentCall = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber))
                        // --- Debemos verificar que exista el permiso en el manifest explícitamente
                        //     ya que el usuario puede rechazar esta petición de permiso --- //
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return
                        }
                        startActivity(intentCall)
                    }else {
                        // --- Denegó el permiso --- //
                        Toast.makeText(this, "Has denegado el permiso", Toast.LENGTH_LONG).show()
                    }
                }

            }

            else -> super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }

    }

    // --- Verificamos que el permiso esté aceptado --- //
    fun ChecarPermiso(permission: String): Boolean{
        val result = this.checkCallingOrSelfPermission(permission)
        return result == PackageManager.PERMISSION_GRANTED
    }

}
