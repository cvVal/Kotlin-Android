package com.aloapps.alarmapp

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat

/**
 * Created by sevevaldez on 17/12/17.
 */
class NotificacionPush {

    val NOTIFICACION = "peticion nueva"
    val NOTIFI_CHANNEL_ID = "miChannelID"


    @RequiresApi(Build.VERSION_CODES.O)
    fun notificacion(context: Context, mensaje: String, numero: Int) {
        val intent = Intent(context, MainActivity::class.java)
        val gestorNotificacion = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notifChannel = NotificationChannel(NOTIFI_CHANNEL_ID, "Mi notificacion",
                    NotificationManager.IMPORTANCE_HIGH)

            notifChannel.description = "Descripcion"
            notifChannel.lightColor = Color.RED
            notifChannel.vibrationPattern = longArrayOf(0, 1000, 500, 1000)
            notifChannel.enableVibration(true)
            gestorNotificacion.createNotificationChannel(notifChannel)
        }

        val builder = NotificationCompat.Builder(context, NOTIFI_CHANNEL_ID)
                .setContentTitle("AlarmApp")
                .setContentText(mensaje)
                .setColorized(true)
                .setColor(Color.RED)
                .setNumber(numero)
                .setSmallIcon(R.drawable.abc_ic_star_black_48dp)
                .setContentIntent(PendingIntent.getActivity(context, 0, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT))
                .setAutoCancel(true)

        if (Build.VERSION.SDK_INT in 19..25) {
            gestorNotificacion.notify(NOTIFICACION, 0, builder.build())
        }else{
            gestorNotificacion.notify(NOTIFICACION.hashCode(), builder.build())
        }
    }
}