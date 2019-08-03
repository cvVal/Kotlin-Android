package com.apps.alo.weatherapp

import Util.Utils
import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import data.HttpClientClima
import data.JSONParseClima
import data.PreferenceCiudad
import kotlinx.android.synthetic.main.activity_main.*
import model.Clima
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import java.io.IOException
import java.io.InputStream
import java.text.DateFormat
import java.text.DecimalFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var clima = Clima()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ciudadPreference : PreferenceCiudad = PreferenceCiudad(this)

        renderClimaDatos(ciudadPreference.ciudad)

    }

    fun renderClimaDatos(ciudad: String) {
        val climaTask = ClimaTask()
        climaTask.execute(*arrayOf(ciudad + "&APPID="+ "3d64ec3dcd96691080a0feaf9010146f" + "&units=metric"))
    }

    @SuppressLint("StaticFieldLeak")
    private inner class DescargarImagenAsync : AsyncTask<String, Void, Bitmap>() {


        override fun doInBackground(vararg p0: String?): Bitmap {
            return descargarImagen(p0[0] as String)
        }

        override fun onPostExecute(result: Bitmap?) {
            imageViewIcon.setImageBitmap(result)
        }

        fun descargarImagen(codigo: String): Bitmap {

            val cliente = DefaultHttpClient()

            val getRequest = HttpGet(Utils.ICON_URL + codigo + ".png")

            try {
                val response = cliente.execute(getRequest)

                val statusCodigo = response.statusLine.statusCode

                if (statusCodigo != HttpStatus.SC_OK) {
                    Log.e("DescargaImagen", "Error: " + statusCodigo)
                    return null!!
                }

                val entity = response.entity

                if (entity != null) {
                    var inputStream : InputStream?
                    inputStream = entity.content

                    val bitmap: Bitmap = BitmapFactory.decodeStream(inputStream)
                    return bitmap

                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null!!
        }

    }

    @SuppressLint("StaticFieldLeak")
    private inner class ClimaTask : AsyncTask<String, Void, Clima>() {


        override fun doInBackground(vararg p0: String?): Clima {

            val datos = HttpClientClima().getWeatherData(p0[0])
            clima = JSONParseClima.getWeather(datos)!!

            clima.icon = clima.condicionActual.icono

            DescargarImagenAsync().execute(clima.icon)

            return clima
        }

        override fun onPostExecute(result: Clima?) {
            super.onPostExecute(result)

            val formatoFecha = DateFormat.getTimeInstance()
            val amanecer = formatoFecha.format(Date(clima.lugar!!.amanecer))
            val puesta = formatoFecha.format(Date(clima.lugar!!.puestaSol))
            val actualizar = formatoFecha.format(Date(clima.lugar!!.ultimaActualizacion))

            val formatoDecimal = DecimalFormat("#.#")
            val formatoTemp = formatoDecimal.format(clima.condicionActual.temperatura)

            textViewCiudad.text = clima.lugar!!.ciudad + "," + clima.lugar!!.pais
            textViewTemp.text = "" + formatoTemp + " C"
            textViewHumedad.text = "Humedad: " + clima.condicionActual.humedad + "%"
            textViewPresion.text = "Presion: " + clima.condicionActual.presion
            textViewViento.text = "Viento: " + clima.viento.velocidad + "mps"
            textViewSunset.text = "Puesta del sol: " + puesta
            textViewSunrise.text = "Amanecer: " + amanecer
            textViewUpdate.text = "Última actualización: " + actualizar
            textViewNube.text = "Nube: " + clima.condicionActual.condicion + "(" + clima.condicionActual.descripcion + ")"
        }
    }

    fun mostrarDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Cambiar Ciudad")

        val ponerCiudad = EditText(this)
        ponerCiudad.inputType = InputType.TYPE_CLASS_TEXT
        ponerCiudad.hint = "Merida,MX"
        builder.setView(ponerCiudad)
        builder.setPositiveButton("OK") {dialogInterface, i ->
            val ciudadPreferencia = PreferenceCiudad(this)
            ciudadPreferencia.ciudad = ponerCiudad.text.toString()

            val ciudadNueva = ciudadPreferencia.ciudad
            renderClimaDatos(ciudadNueva)
        }.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            R.id.menuCambiar -> mostrarDialog()
        }


        return super.onOptionsItemSelected(item)
    }

}