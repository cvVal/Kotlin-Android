package com.aloapps.alarmapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.widget.Toast

/**
 * Created by sevevaldez on 16/12/17.
 */
class MiBroadcastReceiver  : BroadcastReceiver(){
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.action == ("com.gestoralarma")) {

            val mnsg = intent.extras
            Toast.makeText(context, mnsg.getString("mensaje"), Toast.LENGTH_LONG).show()

            val notif = NotificacionPush()
            notif.notificacion(context!!, mnsg.getString("mensaje"), 1)

        } else if (intent.action == ("android.intent.action.BOOT_COMPLETED")) {
            val gDatos = GuardarDatos(context!!)
            gDatos.programarAlarma()
        }
    }
}