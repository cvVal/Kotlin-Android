package com.apps.alo.mediaplayer

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener{

    var mp : MediaPlayer? = null
    val CODIGO_GRABAR = 50
    var uri : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGrabar!!.setOnClickListener { grabar() }
        btnReproducir!!.setOnClickListener { reproducirGrabacion() }
    }
    // ---  Audio con Media Player --- //
    fun sonido(){

        val mediaPlayer = MediaPlayer.create(this, R.raw.sonido)
        mediaPlayer.start()
    }

    // ---  Audio en la nube --- //
    fun audioNube() {
        mp = MediaPlayer()

        // ---  Audio en la nube Async --- //
        mp!!.setOnPreparedListener(this)

        try {
            mp!!.setDataSource("http://algunapagina/algomas.com")
            // ---  preparar asíncronamente --- //
            mp!!.prepareAsync()
            // ---  Métodos audio síncrono --- //

            //mp.prepare()
            //mp.start()

            // ---                           --- //
        }catch (e:IOException){
            e.printStackTrace()
        }
    }

    // ---  Mètodo de la interfaz OnPreparedListener --- //
    override fun onPrepared(p0: MediaPlayer?) {
        mp!!.start()
    }

    // ---  Audio Nativo  --- //
    fun reproductorNativo(){
        val intent = Intent(Intent.ACTION_VIEW)

        //Acceder a la SD card
        val data = Uri.parse("file:///sdcard" + "sonido.mp3")

        //Acceder desde memoria interna
        //val data = Uri.parse("android.resource://" + packageName + "/" + R.raw.sonido)

        getIntent().setDataAndType(data, "audio/mp3")
        startActivity(intent)

    }

    fun grabar(){

        val intent = Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION)
        startActivityForResult(intent, CODIGO_GRABAR)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == CODIGO_GRABAR && resultCode == Activity.RESULT_OK) {
            uri = data!!.data
        }
    }

    fun reproducirGrabacion() {
        val mp = MediaPlayer.create(this, uri)
        mp.start()
    }
}
